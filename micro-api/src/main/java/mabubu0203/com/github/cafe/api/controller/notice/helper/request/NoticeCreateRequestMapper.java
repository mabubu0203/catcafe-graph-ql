package mabubu0203.com.github.cafe.api.controller.notice.helper.request;

import com.netflix.dgs.codegen.types.NoticeCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeRegisterServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.WriteRequestMapper;

@RequiredArgsConstructor
public class NoticeCreateRequestMapper
    implements WriteRequestMapper<NoticeCommand, NoticeRegisterServiceInput> {

  @Override
  public NoticeRegisterServiceInput apply(NoticeCommand request) {
    return NoticeRegisterServiceInput.builder()
        .locationCode(request.getLocationCode())
        .summary(request.getSummary())
        .detail(request.getDetail())
        .build();
  }

}
