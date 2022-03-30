package mabubu0203.com.github.cafe.api.service.notice.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeDeleteServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.notice.NoticeEntity;

public class NoticeDeleteServiceInputConverter
    implements ServiceInputConverter<NoticeDeleteServiceInput, NoticeEntity> {

  @Override
  public NoticeEntity apply(NoticeDeleteServiceInput noticeDeleteServiceInput) {
    return null;
  }

}
