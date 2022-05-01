package mabubu0203.com.github.cafe.api.service.authorization.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.authorization.model.output.AuthenticationUserRegisterServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;

public class AuthenticationUserServiceOutputConverter
    implements
    ServiceOutputConverter<AuthenticationUserEntity, AuthenticationUserRegisterServiceOutput> {

  @Override
  public AuthenticationUserRegisterServiceOutput apply(
      AuthenticationUserEntity authenticationUserEntity) {
    return AuthenticationUserRegisterServiceOutput.builder()
        .userCode(authenticationUserEntity.getUserCodeValue())
        .username(authenticationUserEntity.getUsernameValue())
        .memo(authenticationUserEntity.getMemoValue())
        .version(authenticationUserEntity.getVersionValue())
        .build();
  }

}
