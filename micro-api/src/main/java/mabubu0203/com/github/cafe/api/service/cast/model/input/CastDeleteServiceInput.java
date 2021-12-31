package mabubu0203.com.github.cafe.api.service.cast.model.input;

import lombok.Builder;
import lombok.Value;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

@Builder
@Value
public class CastDeleteServiceInput implements ServiceInput {

  String castCode;
  Integer version;

}
