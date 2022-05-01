package mabubu0203.com.github.cafe.api.service.authorization.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.authorization.model.input.AuthenticationUserRegisterServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;

public class AuthenticationUserRegisterServiceInputConverter implements
    ServiceInputConverter<AuthenticationUserRegisterServiceInput, AuthenticationUserEntity> {

  @Override
  public AuthenticationUserEntity apply(
      AuthenticationUserRegisterServiceInput authenticationUserRegisterServiceInput) {
    return AuthenticationUserEntity.builder()
        .password("")
        .build();
  }

}
