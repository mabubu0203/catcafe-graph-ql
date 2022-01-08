package mabubu0203.com.github.cafe.domain.repository.cast;

import java.time.LocalDateTime;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatSearchConditions;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;
import mabubu0203.com.github.cafe.domain.entity.cast.CastSearchConditions;
import mabubu0203.com.github.cafe.domain.value.code.CastCatCode;
import mabubu0203.com.github.cafe.domain.value.code.CastCode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CastRepository {

  /**
   * キャストを複数取得する
   *
   * @param searchConditions
   * @return
   */
  Flux<CastEntity> search(CastSearchConditions searchConditions);

  /**
   * キャスト(猫)を複数取得する
   *
   * @param searchConditions
   * @return
   */
  Flux<CastCatEntity> search(CastCatSearchConditions searchConditions);

  /**
   * キャストを1件取得する
   *
   * @param castCode
   * @return
   */
  Mono<CastEntity> findByCode(CastCode castCode);

  /**
   * キャスト(猫)を1件取得する
   *
   * @param castCatCode
   * @return
   */
  Mono<CastCatEntity> findByCode(CastCatCode castCatCode);

  /**
   * キャストを1件登録する
   *
   * @param cast
   * @param receptionTime
   * @return
   */
  Mono<CastCode> register(CastEntity cast, LocalDateTime receptionTime);

  /**
   * キャスト(猫)を1件登録する
   *
   * @param castCat
   * @param receptionTime
   * @return
   */
  Mono<CastCatCode> register(CastCatEntity castCat, LocalDateTime receptionTime);

  /**
   * キャストを1件更新する
   *
   * @param cast
   * @param receptionTime
   * @return
   */
  Mono<CastCode> modify(CastEntity cast, LocalDateTime receptionTime);

  /**
   * キャスト(猫)を1件更新する
   *
   * @param castCat
   * @param receptionTime
   * @return
   */
  Mono<CastCatCode> modify(CastCatEntity castCat, LocalDateTime receptionTime);

  /**
   * キャストを1件削除する
   *
   * @param cast
   * @param receptionTime
   * @return
   */
  Mono<CastCode> logicalDelete(CastEntity cast, LocalDateTime receptionTime);

  /**
   * キャスト(猫)を1件削除する
   *
   * @param castCat
   * @param receptionTime
   * @return
   */
  Mono<CastCatCode> logicalDelete(CastCatEntity castCat, LocalDateTime receptionTime);

}
