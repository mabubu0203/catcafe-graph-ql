package mabubu0203.com.github.cafe.domain.repository.cast;

import java.time.LocalDateTime;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;
import mabubu0203.com.github.cafe.domain.value.code.CastCatId;
import mabubu0203.com.github.cafe.domain.value.code.CastId;
import reactor.core.publisher.Mono;

public interface CastRepository {

  /**
   * キャストを1件取得する
   *
   * @param castId
   * @return
   */
  Mono<CastEntity> findBy(CastId castId);

  /**
   * キャスト(猫)を1件取得する
   *
   * @param castCatId
   * @return
   */
  Mono<CastCatEntity> findBy(CastCatId castCatId);

  /**
   * キャストを1件登録する
   *
   * @param cast
   * @param receptionTime
   * @return
   */
  Mono<CastId> resister(CastEntity cast, LocalDateTime receptionTime);

  /**
   * キャスト(猫)を1件登録する
   *
   * @param castCat
   * @param receptionTime
   * @return
   */
  Mono<CastCatId> resister(CastCatEntity castCat, LocalDateTime receptionTime);

  /**
   * キャストを1件更新する
   *
   * @param cast
   * @param receptionTime
   * @return
   */
  Mono<CastId> modify(CastEntity cast, LocalDateTime receptionTime);

  /**
   * キャスト(猫)を1件更新する
   *
   * @param castCat
   * @param receptionTime
   * @return
   */
  Mono<CastCatId> modify(CastCatEntity castCat, LocalDateTime receptionTime);

  /**
   * キャストを1件削除する
   *
   * @param cast
   * @param receptionTime
   * @return
   */
  Mono<CastId> logicalDelete(CastEntity cast, LocalDateTime receptionTime);

  /**
   * キャスト(猫)を1件削除する
   *
   * @param castCat
   * @param receptionTime
   * @return
   */
  Mono<CastCatId> logicalDelete(CastCatEntity castCat, LocalDateTime receptionTime);

}
