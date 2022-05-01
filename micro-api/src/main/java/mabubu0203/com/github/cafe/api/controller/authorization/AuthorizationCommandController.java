package mabubu0203.com.github.cafe.api.controller.authorization;

import com.netflix.dgs.codegen.types.AuthenticationUser;
import com.netflix.dgs.codegen.types.AuthenticationUserCommand;
import com.netflix.dgs.codegen.types.CastCat;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.controller.authorization.helper.request.AuthenticationUserCreateRequestMapper;
import mabubu0203.com.github.cafe.api.controller.authorization.helper.response.AuthenticationUserResponseMapper;
import mabubu0203.com.github.cafe.api.service.authorization.AuthenticationUserRegisterService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class AuthorizationCommandController {

  private final AuthenticationUserRegisterService authenticationUserRegisterService;

  @MutationMapping(name = "authenticationUserCreate")
  public Mono<AuthenticationUser> authenticationUserCreate(
      @Argument("input") @Valid AuthenticationUserCommand input
  ) {
    return Mono.just(input)
        .map(new AuthenticationUserCreateRequestMapper())
        .flatMap(this.authenticationUserRegisterService::action)
        .map(new AuthenticationUserResponseMapper());
  }

}
