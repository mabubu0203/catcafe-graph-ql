package mabubu0203.com.github.cafe.api.controller.notice.helper.request;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeDeleteServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.WriteRequestMapper;

@RequiredArgsConstructor
public class NoticeDeleteRequestMapper
    implements WriteRequestMapper<String, NoticeDeleteServiceInput> {

  private final Integer version;

  @Override
  public NoticeDeleteServiceInput apply(String noticeCode) {
    return null;
  }

}
