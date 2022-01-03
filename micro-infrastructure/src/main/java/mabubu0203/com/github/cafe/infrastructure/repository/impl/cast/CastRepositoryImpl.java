package mabubu0203.com.github.cafe.infrastructure.repository.impl.cast;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Predicate;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.common.exception.ResourceNotFoundException;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatSearchConditions;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;
import mabubu0203.com.github.cafe.domain.entity.cast.CastSearchConditions;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import mabubu0203.com.github.cafe.domain.value.code.CastCatCode;
import mabubu0203.com.github.cafe.domain.value.code.CastCode;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.CastCatSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.CastSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.CastCatTable;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.CastTable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CastRepositoryImpl implements CastRepository {

  private final CastSource castSource;
  private final CastCatSource castCatSource;

  @Override
  public Flux<CastEntity> search(CastSearchConditions searchConditions) {

    Predicate<CastTable> isExists = BaseTable::isExists;
    Predicate<CastTable> castCodeInclude = cast -> {
      var castCodes = searchConditions.castCodes();
      return castCodes.size() == 0 || castCodes.contains(cast.code());
    };
    Predicate<CastTable> locationCodeInclude = cast -> {
      var locationCodes = searchConditions.locationCodes();
      return locationCodes.size() == 0 || locationCodes.contains(cast.locationCode());
    };

    return this.castSource.findAll()
        .filter(isExists.and(castCodeInclude).and(locationCodeInclude))
        .map(CastTable::toEntity);
  }

  @Override
  public Flux<CastCatEntity> search(CastCatSearchConditions searchConditions) {

    Predicate<CastCatTable> isExists = BaseTable::isExists;
    Predicate<CastCatTable> castCatCodeInclude = castCat -> {
      var castCatCodes = searchConditions.castCatCodes();
      return castCatCodes.size() == 0 || castCatCodes.contains(castCat.code());
    };

    return this.castCatSource.findAll()
        .filter(isExists.and(castCatCodeInclude))
        .map(CastCatTable::toEntity);
  }

  @Override
  public Mono<CastEntity> findByCode(CastCode castCode) {
    return this.findDto(castCode)
        .map(CastTable::toEntity);
  }

  @Override
  public Mono<CastCatEntity> findByCode(CastCatCode castCatCode) {
    return this.findDto(castCatCode)
        .map(CastCatTable::toEntity);
  }

  @Override
  public Mono<CastCode> register(CastEntity entity, LocalDateTime receptionTime) {
    return Optional.of(entity)
        .map(this::attach)
        .map(dto -> dto.createdBy(0))
        .map(dto -> this.castSource.insert(dto, receptionTime))
        .orElseThrow(RuntimeException::new)
        .mapNotNull(CastTable::code)
        .map(CastCode::new);
  }

  @Override
  public Mono<CastCatCode> register(CastCatEntity entity, LocalDateTime receptionTime) {
    return Optional.of(entity)
        .map(this::attach)
        .map(dto -> dto.createdBy(0))
        .map(dto -> this.castCatSource.insert(dto, receptionTime))
        .orElseThrow(RuntimeException::new)
        .mapNotNull(CastCatTable::code)
        .map(CastCatCode::new);
  }

  @Override
  public Mono<CastCode> modify(CastEntity entity, LocalDateTime receptionTime) {
    return this.findDto(entity.castCode())
        .map(dto -> this.attach(dto, entity))
        .map(dto -> dto.updatedBy(0))
        .flatMap(dto -> this.castSource.update(dto, receptionTime))
        .mapNotNull(CastTable::code)
        .map(CastCode::new);
  }

  @Override
  public Mono<CastCatCode> modify(CastCatEntity entity, LocalDateTime receptionTime) {
    return this.findDto(entity.castCatCode())
        .map(dto -> this.attach(dto, entity))
        .map(dto -> dto.updatedBy(0))
        .flatMap(dto -> this.castCatSource.update(dto, receptionTime))
        .mapNotNull(CastCatTable::code)
        .map(CastCatCode::new);
  }

  @Override
  public Mono<CastCode> logicalDelete(CastEntity entity, LocalDateTime receptionTime) {
    return this.findDto(entity.castCode())
        .map(dto -> dto.version(entity.getVersionValue()))
        .flatMap(dto -> this.castSource.logicalDelete(dto, receptionTime))
        .mapNotNull(CastTable::code)
        .map(CastCode::new);
  }

  @Override
  public Mono<CastCatCode> logicalDelete(CastCatEntity entity, LocalDateTime receptionTime) {
    return this.findDto(entity.castCatCode())
        .map(dto -> dto.version(entity.getVersionValue()))
        .flatMap(dto -> this.castCatSource.logicalDelete(dto, receptionTime))
        .mapNotNull(CastCatTable::code)
        .map(CastCatCode::new);
  }

  private Mono<CastTable> findDto(CastCode castCode) {
    return this.castSource.findByCode(castCode.value())
        .filter(BaseTable::isExists)
        // 404で返却するためのエラーを検討
        .switchIfEmpty(Mono.error(new ResourceNotFoundException("キャストが存在しません")));
  }

  private Mono<CastCatTable> findDto(CastCatCode castCatCode) {
    return this.castCatSource.findByCode(castCatCode.value())
        .filter(BaseTable::isExists)
        // 404で返却するためのエラーを検討
        .switchIfEmpty(Mono.error(new ResourceNotFoundException("キャスト(猫)が存在しません")));
  }

  private CastTable attach(CastEntity entity) {
    return this.attach(null, entity);
  }

  private CastTable attach(CastTable dto, CastEntity entity) {
    return Optional.ofNullable(dto)
        .orElse(new CastTable())
        .attach(entity);
  }

  private CastCatTable attach(CastCatEntity entity) {
    return this.attach(null, entity);
  }

  private CastCatTable attach(CastCatTable dto, CastCatEntity entity) {
    return Optional.ofNullable(dto)
        .orElse(new CastCatTable())
        .attach(entity);
  }

}
