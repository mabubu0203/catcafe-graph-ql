package mabubu0203.com.github.cafe.api.controller.authorization.helper.response;

import com.netflix.dgs.codegen.types.AuthenticationUser;
import mabubu0203.com.github.cafe.api.service.authorization.model.output.AuthenticationUserRegisterServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.ResponseMapper;

public class AuthenticationUserResponseMapper
    implements ResponseMapper<AuthenticationUserRegisterServiceOutput, AuthenticationUser> {

  @Override
  public AuthenticationUser apply(AuthenticationUserRegisterServiceOutput output) {
    return AuthenticationUser.newBuilder()
        .code(output.userCode())
        .username(output.username())
        .memo(output.memo())
        .version(output.version())
        .build();
  }

}
