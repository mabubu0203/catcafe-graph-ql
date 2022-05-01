package mabubu0203.com.github.cafe.api.service.authorization;

import mabubu0203.com.github.cafe.api.service.authorization.model.input.AuthenticationUserRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.authorization.model.output.AuthenticationUserRegisterServiceOutput;
import mabubu0203.com.github.cafe.common.service.WriteApplicationService;

public interface AuthenticationUserRegisterService
    extends
    WriteApplicationService<AuthenticationUserRegisterServiceInput, AuthenticationUserRegisterServiceOutput> {

}
