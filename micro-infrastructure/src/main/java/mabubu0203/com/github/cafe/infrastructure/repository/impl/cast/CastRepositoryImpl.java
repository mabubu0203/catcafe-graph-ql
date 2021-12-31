package mabubu0203.com.github.cafe.infrastructure.repository.impl.cast;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import mabubu0203.com.github.cafe.domain.value.code.CastCatId;
import mabubu0203.com.github.cafe.domain.value.code.CastId;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CastRepositoryImpl implements CastRepository {

  @Override
  public Mono<CastEntity> findBy(CastId castId) {
    return Mono.empty();
  }

  @Override
  public Mono<CastCatEntity> findBy(CastCatId castCatId) {
    return Mono.empty();
  }

  @Override
  public Mono<CastId> resister(CastEntity entity, LocalDateTime receptionTime) {
    return Mono.empty();
  }

  @Override
  public Mono<CastCatId> resister(CastCatEntity entity, LocalDateTime receptionTime) {
    return Mono.empty();
  }

  @Override
  public Mono<CastId> modify(CastEntity entity, LocalDateTime receptionTime) {
    return Mono.empty();
  }

  @Override
  public Mono<CastCatId> modify(CastCatEntity entity, LocalDateTime receptionTime) {
    return Mono.empty();
  }

  @Override
  public Mono<CastId> logicalDelete(CastEntity entity, LocalDateTime receptionTime) {
    return Mono.empty();
  }

  @Override
  public Mono<CastCatId> logicalDelete(CastCatEntity entity, LocalDateTime receptionTime) {
    return Mono.empty();
  }

}
