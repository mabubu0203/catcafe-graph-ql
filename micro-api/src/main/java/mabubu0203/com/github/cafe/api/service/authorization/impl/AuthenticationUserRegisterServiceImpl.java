package mabubu0203.com.github.cafe.api.service.authorization.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.authorization.AuthenticationUserRegisterService;
import mabubu0203.com.github.cafe.api.service.authorization.model.input.AuthenticationUserRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.authorization.model.output.AuthenticationUserRegisterServiceOutput;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthenticationUserRegisterServiceImpl implements AuthenticationUserRegisterService {

  @Override
  public Mono<AuthenticationUserRegisterServiceOutput> action(
      AuthenticationUserRegisterServiceInput input) {
    return null;
  }

  @Override
  public Mono<AuthenticationUserRegisterServiceOutput> onAfterSave(
      AuthenticationUserRegisterServiceOutput output) {
    return null;
  }

}
