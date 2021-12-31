package mabubu0203.com.github.cafe.domain.entity.notice;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import mabubu0203.com.github.cafe.domain.value.code.NoticeCode;
import mabubu0203.com.github.cafe.domain.value.code.NoticeId;
import mabubu0203.com.github.cafe.domain.value.code.StoreId;

/**
 * お知らせ
 */
@Builder
@Value
@With
public class NoticeEntity {

  @Deprecated
  NoticeId noticeId;
  NoticeCode noticeCode;
  @Deprecated
  StoreId storeId;
  LocationCode locationCode;
  String summary;
  String detail;
  LocalDateTime publicationStartDateTime;
  LocalDateTime publicationEndDateTime;
  Integer version;

  @Deprecated
  public Integer getNoticeIdValue() {
    return Optional.ofNullable(this.noticeId)
        .map(NoticeId::value)
        .orElse(null);
  }

  public String getNoticeCodeValue() {
    return Optional.ofNullable(this.noticeCode)
        .map(NoticeCode::value)
        .orElse(null);
  }

  @Deprecated
  public Integer getStoreIdValue() {
    return Optional.ofNullable(this.storeId)
        .map(StoreId::value)
        .orElse(null);
  }

  public String getLocationCodeValue() {
    return Optional.ofNullable(this.locationCode)
        .map(LocationCode::value)
        .orElse(null);
  }

}
