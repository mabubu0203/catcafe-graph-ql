package mabubu0203.com.github.cafe.api.service.notice.model.input;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

@Accessors(fluent = true)
@Builder
@Value
public class NoticeModifyServiceInput implements ServiceInput {

  String noticeCode;
  String locationCode;
  String summary;
  String detail;
  Integer version;

}
