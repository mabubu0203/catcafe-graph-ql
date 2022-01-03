package mabubu0203.com.github.cafe.domain.entity.notice;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import mabubu0203.com.github.cafe.domain.value.code.NoticeCode;

/**
 * お知らせ
 */
@Accessors(fluent = true)
@Builder
@Value
@With
public class NoticeEntity {

  NoticeCode noticeCode;
  LocationCode locationCode;
  String summary;
  String detail;
  LocalDateTime publicationStartDateTime;
  LocalDateTime publicationEndDateTime;
  Version version;

  public String getNoticeCodeValue() {
    return Optional.ofNullable(this.noticeCode)
        .map(NoticeCode::value)
        .orElse(null);
  }

  public String getLocationCodeValue() {
    return Optional.ofNullable(this.locationCode)
        .map(LocationCode::value)
        .orElse(null);
  }

  public Integer getVersionValue() {
    return Optional.ofNullable(this.version)
        .map(Version::value)
        .orElse(null);
  }

}
