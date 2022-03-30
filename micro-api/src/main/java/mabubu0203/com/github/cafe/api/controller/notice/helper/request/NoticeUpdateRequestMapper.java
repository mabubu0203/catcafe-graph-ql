package mabubu0203.com.github.cafe.api.controller.notice.helper.request;

import com.netflix.dgs.codegen.types.NoticeCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeModifyServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.WriteRequestMapper;

@RequiredArgsConstructor
public class NoticeUpdateRequestMapper
    implements WriteRequestMapper<NoticeCommand, NoticeModifyServiceInput> {

  private final String noticeCode;
  private final Integer version;

  @Override
  public NoticeModifyServiceInput apply(NoticeCommand noticeCommand) {
    return null;
  }

}
