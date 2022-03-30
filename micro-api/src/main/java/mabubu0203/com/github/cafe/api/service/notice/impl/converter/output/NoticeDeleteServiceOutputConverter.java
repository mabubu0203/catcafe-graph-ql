package mabubu0203.com.github.cafe.api.service.notice.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.notice.model.output.NoticeDeleteServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.value.code.NoticeCode;

public class NoticeDeleteServiceOutputConverter
    implements ServiceOutputConverter<NoticeCode, NoticeDeleteServiceOutput> {

  @Override
  public NoticeDeleteServiceOutput apply(NoticeCode noticeCode) {
    return null;
  }

}
