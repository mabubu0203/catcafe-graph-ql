package mabubu0203.com.github.cafe.domain.repository.notice;

import java.time.LocalDateTime;
import mabubu0203.com.github.cafe.domain.entity.notice.NoticeEntity;
import mabubu0203.com.github.cafe.domain.entity.notice.NoticeSearchConditions;
import mabubu0203.com.github.cafe.domain.value.code.NoticeCode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NoticeRepository {

  /**
   * お知らせを複数取得する
   *
   * @param searchConditions
   * @return
   */
  Flux<NoticeEntity> search(NoticeSearchConditions searchConditions);

  /**
   * お知らせを1件取得する
   *
   * @param noticeCode
   * @return
   */
  Mono<NoticeEntity> findByCode(NoticeCode noticeCode);

  /**
   * お知らせを1件登録する
   *
   * @param notice
   * @param receptionTime
   * @return
   */
  Mono<NoticeCode> register(NoticeEntity notice, LocalDateTime receptionTime);

  /**
   * お知らせを1件更新する
   *
   * @param notice
   * @param receptionTime
   * @return
   */
  Mono<NoticeCode> modify(NoticeEntity notice, LocalDateTime receptionTime);

  /**
   * お知らせを1件削除する
   *
   * @param notice
   * @param receptionTime
   * @return
   */
  Mono<NoticeCode> logicalDelete(NoticeEntity notice, LocalDateTime receptionTime);

}
