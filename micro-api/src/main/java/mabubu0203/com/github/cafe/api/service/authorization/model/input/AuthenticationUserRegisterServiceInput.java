package mabubu0203.com.github.cafe.api.service.authorization.model.input;

import java.util.List;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

@Accessors(fluent = true)
@Builder
@Value
public class AuthenticationUserRegisterServiceInput implements ServiceInput {

  String username;

  String password;

  List<String> roleKeys;

  String memo;

}
