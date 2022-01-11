package mabubu0203.com.github.cafe.infrastructure.repository.impl.location;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Predicate;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.common.exception.ResourceNotFoundException;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import mabubu0203.com.github.cafe.domain.entity.location.LocationEntity;
import mabubu0203.com.github.cafe.domain.entity.location.LocationSearchConditions;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import mabubu0203.com.github.cafe.infrastructure.source.elastic.LocationDocumentSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.LocationTableSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.LocationTable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class LocationRepositoryImpl implements LocationRepository {

  private final LocationDocumentSource locationDocumentSource;
  private final LocationTableSource locationTableSource;

  @Override
  public Flux<LocationEntity> search(LocationSearchConditions searchConditions) {
    Predicate<LocationTable> isExists = BaseTable::isExists;

    Predicate<LocationTable> locationCodeInclude = location -> {
      var locationCodes = searchConditions.locationCodes();
      return locationCodes.size() == 0 || locationCodes.contains(location.code());
    };

    return this.locationTableSource.findAll()
        .filter(isExists.and(locationCodeInclude))
        .map(LocationTable::toEntity);
  }

  @Override
  public Mono<LocationEntity> findByCode(LocationCode locationCode) {
    return this.findDto(locationCode)
        .map(LocationTable::toEntity);
  }

  @Override
  public Mono<LocationCode> register(LocationEntity entity, LocalDateTime receptionTime) {
    return Mono.just(entity)
        .map(this::attach)
        .map(dto -> dto.createdBy(0))
        .flatMap(dto -> this.locationTableSource.insert(dto, receptionTime))
        .map(LocationTable::code)
        .map(LocationCode::new);
  }

  @Override
  public Mono<LocationCode> modify(LocationEntity entity, LocalDateTime receptionTime) {
    return this.findDto(entity.locationCode())
        .map(dto -> this.attach(dto, entity))
        .map(dto -> dto.updatedBy(0))
        .flatMap(dto -> this.locationTableSource.update(dto, receptionTime))
        .map(LocationTable::code)
        .map(LocationCode::new);
  }

  @Override
  public Mono<LocationCode> logicalDelete(LocationEntity entity, LocalDateTime receptionTime) {
    return this.findDto(entity.locationCode())
        .map(dto -> dto.version(entity.getVersionValue()))
        .flatMap(dto -> this.locationTableSource.logicalDelete(dto, receptionTime))
        .map(LocationTable::code)
        .map(LocationCode::new);
  }

  private Mono<LocationTable> findDto(LocationCode locationCode) {
    return this.locationTableSource.findByCode(locationCode.value())
        .filter(BaseTable::isExists)
        // 404で返却するためのエラーを検討
        .switchIfEmpty(Mono.error(new ResourceNotFoundException("所在地/店舗が存在しません")));
  }

  private LocationTable attach(LocationEntity entity) {
    return this.attach(null, entity);
  }

  private LocationTable attach(LocationTable dto, LocationEntity entity) {
    return Optional.ofNullable(dto)
        .orElse(new LocationTable())
        .attach(entity);
  }

}
