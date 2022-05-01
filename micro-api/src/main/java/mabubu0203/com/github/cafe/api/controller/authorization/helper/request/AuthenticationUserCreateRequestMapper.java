package mabubu0203.com.github.cafe.api.controller.authorization.helper.request;

import com.netflix.dgs.codegen.types.AuthenticationUserCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.authorization.model.input.AuthenticationUserRegisterServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.WriteRequestMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class AuthenticationUserCreateRequestMapper
    implements
    WriteRequestMapper<AuthenticationUserCommand, AuthenticationUserRegisterServiceInput> {

  private final PasswordEncoder passwordEncoder;

  @Override
  public AuthenticationUserRegisterServiceInput apply(
      AuthenticationUserCommand request) {
    var hashedPassword = this.passwordEncoder.encode(request.getPassword());
    return AuthenticationUserRegisterServiceInput.builder()
        .username(request.getUsername())
        .password(hashedPassword)
        .roleKeys(request.getRoleKeys())
        .memo(request.getMemo())
        .build();
  }

}
