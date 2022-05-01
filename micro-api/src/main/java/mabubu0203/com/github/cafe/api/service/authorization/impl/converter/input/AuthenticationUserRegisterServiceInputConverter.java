package mabubu0203.com.github.cafe.api.service.authorization.impl.converter.input;

import java.util.ArrayList;
import mabubu0203.com.github.cafe.api.service.authorization.model.input.AuthenticationUserRegisterServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.authorization.Username;
import mabubu0203.com.github.cafe.domain.value.code.UserCode;

public class AuthenticationUserRegisterServiceInputConverter
    implements
    ServiceInputConverter<AuthenticationUserRegisterServiceInput, AuthenticationUserEntity> {

  @Override
  public AuthenticationUserEntity apply(AuthenticationUserRegisterServiceInput input) {
    var userCode = UserCode.newCode();
    var username = new Username(input.username());
    var memo = new Memo(input.memo());
    var version = Version.empty();
    return AuthenticationUserEntity.builder()
        .userCode(userCode)
        .username(username)
        .password(input.password())
        .roles(new ArrayList<>())
        .memo(memo)
        .version(version)
        .build();
  }

}
