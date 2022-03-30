package mabubu0203.com.github.cafe.api.service.notice.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeDeleteServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.notice.NoticeEntity;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.code.NoticeCode;

public class NoticeDeleteServiceInputConverter
    implements ServiceInputConverter<NoticeDeleteServiceInput, NoticeEntity> {

  @Override
  public NoticeEntity apply(NoticeDeleteServiceInput input) {
    var noticeCode = new NoticeCode(input.noticeCode());
    var version = new Version(input.version());
    return NoticeEntity.builder()
        .noticeCode(noticeCode)
        .version(version)
        .build();
  }

}
