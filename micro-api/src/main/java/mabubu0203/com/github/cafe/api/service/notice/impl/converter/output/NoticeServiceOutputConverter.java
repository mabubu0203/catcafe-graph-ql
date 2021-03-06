package mabubu0203.com.github.cafe.api.service.notice.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.notice.model.output.NoticeServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.entity.notice.NoticeEntity;

public class NoticeServiceOutputConverter
    implements ServiceOutputConverter<NoticeEntity, NoticeServiceOutput> {

  @Override
  public NoticeServiceOutput apply(NoticeEntity notice) {
    return NoticeServiceOutput.builder()
        .noticeCode(notice.getNoticeCodeValue())
        .locationCode(notice.getLocationCodeValue())
        .summary(notice.summary())
        .detail(notice.detail())
        .version(notice.getVersionValue())
        .build();
  }

}
