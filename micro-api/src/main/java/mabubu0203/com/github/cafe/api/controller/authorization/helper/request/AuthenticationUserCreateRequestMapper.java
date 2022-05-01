package mabubu0203.com.github.cafe.api.controller.authorization.helper.request;

import com.netflix.dgs.codegen.types.AuthenticationUserCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.authorization.model.input.AuthenticationUserRegisterServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.WriteRequestMapper;

@RequiredArgsConstructor
public class AuthenticationUserCreateRequestMapper
    implements
    WriteRequestMapper<AuthenticationUserCommand, AuthenticationUserRegisterServiceInput> {

  @Override
  public AuthenticationUserRegisterServiceInput apply(
      AuthenticationUserCommand authenticationUserCommand) {
    return AuthenticationUserRegisterServiceInput.builder()
        // passwordはここでハッシュ化する
        .build();
  }

}
