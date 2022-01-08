package mabubu0203.com.github.cafe.api.service.notice.model.input;

import java.util.List;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

@Accessors(fluent = true)
@Builder
@Value
public class NoticeSearchServiceInput implements ServiceInput {

  List<String> locationCodes;
  List<String> noticeCodes;

}