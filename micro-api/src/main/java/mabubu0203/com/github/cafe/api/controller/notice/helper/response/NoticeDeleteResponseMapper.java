package mabubu0203.com.github.cafe.api.controller.notice.helper.response;

import mabubu0203.com.github.cafe.api.service.notice.model.output.NoticeDeleteServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.DeleteResponseMapper;

public class NoticeDeleteResponseMapper
    implements DeleteResponseMapper<NoticeDeleteServiceOutput, String> {

  @Override
  public String apply(NoticeDeleteServiceOutput output) {
    return output.noticeCode();
  }
}
