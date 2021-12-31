package mabubu0203.com.github.cafe.domain.entity.notice;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import mabubu0203.com.github.cafe.domain.value.code.NoticeId;
import mabubu0203.com.github.cafe.domain.value.code.StoreId;

/**
 * お知らせ
 */
@Builder
@Value
@With
public class NoticeEntity {

  NoticeId noticeId;
  StoreId storeId;
  String summary;
  String detail;
  LocalDateTime publicationStartDateTime;
  LocalDateTime publicationEndDateTime;
  LocalDateTime createdDateTime;
  Integer version;
  LocalDateTime updatedDateTime;

  public Integer getNoticeIdValue() {
    return Optional.ofNullable(this.noticeId)
        .map(NoticeId::value)
        .orElse(null);
  }

  public Integer getStoreIdValue() {
    return Optional.ofNullable(this.storeId)
        .map(StoreId::value)
        .orElse(null);
  }

}
