package mabubu0203.com.github.cafe.api.service.notice.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeSearchServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.notice.NoticeSearchConditions;

public class NoticeSearchServiceInputConverter
    implements ServiceInputConverter<NoticeSearchServiceInput, NoticeSearchConditions> {

  @Override
  public NoticeSearchConditions apply(NoticeSearchServiceInput noticeSearchServiceInput) {
    return null;
  }

}
