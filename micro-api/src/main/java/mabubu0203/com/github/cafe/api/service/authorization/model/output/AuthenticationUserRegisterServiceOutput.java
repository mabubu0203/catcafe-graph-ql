package mabubu0203.com.github.cafe.api.service.authorization.model.output;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.service.model.ServiceOutput;

@Accessors(fluent = true)
@Builder
@Value
public class AuthenticationUserRegisterServiceOutput implements ServiceOutput {

  String userCode;
  String username;
  String memo;
  Integer version;

}
