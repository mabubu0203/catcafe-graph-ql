package mabubu0203.com.github.cafe.infrastructure.repository.impl.cast;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import mabubu0203.com.github.cafe.domain.value.code.CastCatCode;
import mabubu0203.com.github.cafe.domain.value.code.CastCode;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CastRepositoryImpl implements CastRepository {

  @Override
  public Mono<CastEntity> findByCode(CastCode castCode) {
    return Mono.empty();
  }

  @Override
  public Mono<CastCatEntity> findByCode(CastCatCode castCatCode) {
    return Mono.empty();
  }

  @Override
  public Mono<CastCode> register(CastEntity entity, LocalDateTime receptionTime) {
    return Mono.empty();
  }

  @Override
  public Mono<CastCatCode> register(CastCatEntity entity, LocalDateTime receptionTime) {
    return Mono.empty();
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

}
