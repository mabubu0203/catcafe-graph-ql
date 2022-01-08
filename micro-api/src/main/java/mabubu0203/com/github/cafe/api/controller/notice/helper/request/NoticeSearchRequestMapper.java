package mabubu0203.com.github.cafe.api.controller.notice.helper.request;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeSearchServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.ReadRequestMapper;

@RequiredArgsConstructor
public class NoticeSearchRequestMapper
    implements ReadRequestMapper<NoticeSearchServiceInput> {

  private final List<String> noticeCodes;
  private final List<String> locationCodes;

  @Override
  public NoticeSearchServiceInput get() {
    return NoticeSearchServiceInput.builder()
        .noticeCodes(this.noticeCodes)
        .locationCodes(this.locationCodes)
        .build();
  }

}
