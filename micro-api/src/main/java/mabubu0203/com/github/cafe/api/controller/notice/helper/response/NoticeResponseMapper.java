package mabubu0203.com.github.cafe.api.controller.notice.helper.response;

import com.netflix.dgs.codegen.types.Notice;
import mabubu0203.com.github.cafe.api.service.notice.model.output.NoticeServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.ResponseMapper;

public class NoticeResponseMapper
    implements ResponseMapper<NoticeServiceOutput, Notice> {

  @Override
  public Notice apply(NoticeServiceOutput output) {
    return new Notice.Builder()
        .code(output.noticeCode())
        .locationCode(output.locationCode())
        .summary(output.summary())
        .detail(output.detail())
        .publicationStartDateTime(null)
        .publicationEndDateTime(null)
        .version(output.version())
        .build();
  }

}
