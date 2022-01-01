package mabubu0203.com.github.cafe.infrastructure.repository.impl.cast;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Predicate;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.common.exception.ResourceNotFoundException;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import mabubu0203.com.github.cafe.domain.value.code.CastCatCode;
import mabubu0203.com.github.cafe.domain.value.code.CastCode;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.CastCatSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.CastCatTable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CastRepositoryImpl implements CastRepository {

  private final CastCatSource castCatSource;


  @Override
  public Flux<CastEntity> search() {
    return null;
  }

  @Override
  public Flux<CastCatEntity> search(String castCatCode) {
    Predicate<CastCatTable> castCatCodeInclude = castCat -> castCat.code().equals(castCatCode);
    return this.castCatSource.findAll()
        .filter(BaseTable::isExists)
        .filter(castCatCodeInclude)
        .map(CastCatTable::toEntity);
  }

  @Override
  public Mono<CastEntity> findByCode(CastCode castCode) {
    return Mono.empty();
  }

  @Override
  public Mono<CastCatEntity> findByCode(CastCatCode castCatCode) {
    return this.castCatSource.findByCode(castCatCode.value())
        .filter(BaseTable::isExists)
        // 404で返却するためのエラーを検討
        .switchIfEmpty(Mono.error(new ResourceNotFoundException("キャスト(猫)が存在しません")))
        .map(CastCatTable::toEntity);
  }

  @Override
  public Mono<CastCode> register(CastEntity entity, LocalDateTime receptionTime) {
    return Mono.empty();
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
    return Mono.empty();
  }

  @Override
  public Mono<CastCatCode> modify(CastCatEntity entity, LocalDateTime receptionTime) {
    return Mono.empty();
  }

  @Override
  public Mono<CastCode> logicalDelete(CastEntity entity, LocalDateTime receptionTime) {
    return Mono.empty();
  }

  @Override
  public Mono<CastCatCode> logicalDelete(CastCatEntity entity, LocalDateTime receptionTime) {
    return Mono.empty();
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
