package mabubu0203.com.github.cafe.api.service.notice.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeModifyServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.notice.NoticeEntity;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import mabubu0203.com.github.cafe.domain.value.code.NoticeCode;

public class NoticeModifyServiceInputConverter
    implements ServiceInputConverter<NoticeModifyServiceInput, NoticeEntity> {

  @Override
  public NoticeEntity apply(NoticeModifyServiceInput input) {
    var noticeCode = new NoticeCode(input.noticeCode());
    var locationCode = new LocationCode(input.locationCode());
    var version = new Version(input.version());
    return NoticeEntity.builder()
        .noticeCode(noticeCode)
        .locationCode(locationCode)
        .detail(input.detail())
        .summary(input.summary())
        .publicationStartDateTime(null)
        .publicationEndDateTime(null)
        .version(version)
        .build();
  }

}
