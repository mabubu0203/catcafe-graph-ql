package mabubu0203.com.github.cafe.infrastructure.repository.impl.location;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import mabubu0203.com.github.cafe.common.exception.ResourceNotFoundException;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import mabubu0203.com.github.cafe.domain.check.message.streams.publisher.LocationEventPublisher;
import mabubu0203.com.github.cafe.domain.entity.location.LocationEntity;
import mabubu0203.com.github.cafe.domain.entity.location.LocationSearchConditions;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import mabubu0203.com.github.cafe.infrastructure.source.elastic.LocationDocumentSource;
import mabubu0203.com.github.cafe.infrastructure.source.elastic.dto.LocationDocument;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.LocationTableSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.LocationTable;
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchOperations;
import org.springframework.data.elasticsearch.core.index.AliasAction;
import org.springframework.data.elasticsearch.core.index.AliasActionParameters;
import org.springframework.data.elasticsearch.core.index.AliasActions;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log
@Repository
@RequiredArgsConstructor
public class LocationRepositoryImpl implements LocationRepository {

  private final LocationDocumentSource locationDocumentSource;
  private final LocationEventPublisher locationEventPublisher;
  private final LocationTableSource locationTableSource;
  private final ReactiveElasticsearchOperations elasticsearchOperations;

  @Override
  public Flux<LocationEntity> search(LocationSearchConditions searchConditions) {
    Predicate<LocationDocument> locationCodeInclude = location -> {
      var locationCodes = searchConditions.locationCodes();
      return locationCodes.size() == 0 || locationCodes.contains(location.code());
    };

    return this.locationDocumentSource.findAll()
        .filter(locationCodeInclude)
        .map(LocationDocument::toEntity);
  }

  @Override
  public Mono<LocationEntity> findByCode(LocationCode locationCode) {
    return this.findTable(locationCode)
        .map(LocationTable::toEntity);
  }

  @Override
  public Mono<LocationCode> register(LocationEntity entity, LocalDateTime receptionTime) {
    return Mono.just(entity)
        .map(dto -> this.attach(null, entity))
        .map(dto -> dto.createdBy(0))
        .flatMap(dto -> this.locationTableSource.insert(dto, receptionTime))
        .map(LocationTable::code)
        .map(LocationCode::new);
  }

  @Override
  public Mono<LocationCode> modify(LocationEntity entity, LocalDateTime receptionTime) {
    return this.findTable(entity.locationCode())
        .map(dto -> this.attach(dto, entity))
        .map(dto -> dto.updatedBy(0))
        .flatMap(dto -> this.locationTableSource.update(dto, receptionTime))
        .map(LocationTable::code)
        .map(LocationCode::new);
  }

  @Override
  public Mono<LocationCode> logicalDelete(LocationEntity entity, LocalDateTime receptionTime) {
    return this.findTable(entity.locationCode())
        .map(dto -> dto.version(entity.getVersionValue()))
        .flatMap(dto -> this.locationTableSource.logicalDelete(dto, receptionTime))
        .map(LocationTable::code)
        .map(LocationCode::new);
  }

  @Override
  public Mono<String> publishEvent(LocationCode locationCode) {
    return this.locationEventPublisher.publish(locationCode);
  }

  @Override
  public Mono<Void> replacement(LocationCode locationCode, Instant receptionTime) {
    var code = locationCode.value();
    return
        this.locationDocumentSource.findByCode(code)
            .flatMap(document ->
                this.findTable(locationCode)
                    .flatMap(table ->
                        // 更新
                        Mono.just(table)
                            .map(LocationTable::toEntity)
                            .map(document::attach)
                            .flatMap(dto -> this.locationDocumentSource.update(dto, receptionTime))
                    )
                    .onErrorResume(e ->
                        // 削除
                        this.locationDocumentSource.deleteByCode(code)
                            .thenReturn(document)// 使用しない
                    )
            )
            .switchIfEmpty(
                // 登録
                this.findTable(locationCode)
                    .map(LocationTable::toEntity)
                    .map(new LocationDocument()::attach)
                    .flatMap(dto -> this.locationDocumentSource.insert(dto, receptionTime))
            )
            .then();
  }

  @Override
  public Long allReplacement(Instant receptionTime) {
    var today = LocalDate.now();
    var newIndexName = LocationDocument.INDEX_NAME
        .replace("{yyyy-MM-dd}", today.toString());
    var oldIndexName = LocationDocument.INDEX_NAME
        .replace("{yyyy-MM-dd}", today.minusDays(1L).toString());

    // index作成
    var indexOperations = this.elasticsearchOperations.indexOps(LocationDocument.class);

    indexOperations.create().block();

    // 直す
    var count = this.locationTableSource.findAll()
        .filter(BaseTable::isExists)
        .map(LocationTable::toEntity)
        .map(new LocationDocument()::attach)
        .flatMap(dto -> this.locationDocumentSource.insert(dto, receptionTime))
        .count()
        .block();

    indexOperations.alias(
            new AliasActions()
                .add(
                    // Aliasに新しいindexを追加する
                    new AliasAction.Add(
                        AliasActionParameters.builder()
                            .withIndices(newIndexName)
                            .withAliases(LocationDocument.ALIAS)
                            .build()
                    )
                )
//            .add(
//                // Aliasから古いindexを削除する
//                new AliasAction.Remove(
//                    AliasActionParameters.builder()
//                        .withIndices(oldIndexName)
//                        .withAliases(LocationDocument.ALIAS)
//                        .build()
//                )
//            )
        )
        .block();

    return count;
  }

  private Mono<LocationTable> findTable(LocationCode locationCode) {
    return this.locationTableSource.findByCode(locationCode.value())
        .filter(BaseTable::isExists)
        // 404で返却するためのエラーを検討
        .switchIfEmpty(Mono.error(new ResourceNotFoundException("所在地/店舗が存在しません")));
  }

  private LocationTable attach(LocationTable dto, LocationEntity entity) {
    return Optional.ofNullable(dto)
        .orElse(new LocationTable())
        .attach(entity);
  }

}
