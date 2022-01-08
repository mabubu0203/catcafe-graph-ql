package mabubu0203.com.github.cafe.api.service.notice.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeRegisterServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.notice.NoticeEntity;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import mabubu0203.com.github.cafe.domain.value.code.NoticeCode;

public class NoticeRegisterServiceInputConverter
    implements ServiceInputConverter<NoticeRegisterServiceInput, NoticeEntity> {

  @Override
  public NoticeEntity apply(NoticeRegisterServiceInput input) {
    var noticeCode = NoticeCode.newCode();
    var locationCode = new LocationCode(input.locationCode());
    var version = Version.empty();
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
