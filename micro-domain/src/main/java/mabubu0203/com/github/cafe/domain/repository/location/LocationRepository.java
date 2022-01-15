package mabubu0203.com.github.cafe.domain.repository.location;

import java.time.Instant;
import java.time.LocalDateTime;
import mabubu0203.com.github.cafe.domain.entity.location.LocationEntity;
import mabubu0203.com.github.cafe.domain.entity.location.LocationSearchConditions;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LocationRepository {

  /**
   * 所在地/店舗を複数取得する
   *
   * @param searchConditions
   * @return
   */
  Flux<LocationEntity> search(LocationSearchConditions searchConditions);

  /**
   * 所在地/店舗を1件取得する
   *
   * @param locationCode
   * @return
   */
  Mono<LocationEntity> findByCode(LocationCode locationCode);

  /**
   * 所在地/店舗を1件登録する
   *
   * @param location
   * @param receptionTime
   * @return
   */
  Mono<LocationCode> register(LocationEntity location, LocalDateTime receptionTime);

  /**
   * 所在地/店舗を1件更新する
   *
   * @param location
   * @param receptionTime
   * @return
   */
  Mono<LocationCode> modify(LocationEntity location, LocalDateTime receptionTime);

  /**
   * 所在地/店舗を1件削除する
   *
   * @param location
   * @param receptionTime
   * @return
   */
  Mono<LocationCode> logicalDelete(LocationEntity location, LocalDateTime receptionTime);

  /**
   * キャッシュを洗い替える
   *
   * @param receptionTime
   * @return 洗い替え件数
   */
  Integer replacement(Instant receptionTime);

}
