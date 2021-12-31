package mabubu0203.com.github.cafe.domain.entity.notice;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.Builder;
import lombok.Getter;
import mabubu0203.com.github.cafe.domain.value.code.NoticeId;
import mabubu0203.com.github.cafe.domain.value.code.StoreId;

/**
 * お知らせ
 */
@Builder
@Getter
public class NoticeEntity {

  private final NoticeId noticeId;
  private final StoreId storeId;
  private final String summary;
  private final String detail;
  private final LocalDateTime publicationStartDateTime;
  private final LocalDateTime publicationEndDateTime;
  private final LocalDateTime createdDateTime;
  private final Integer version;
  private final LocalDateTime updatedDateTime;

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
