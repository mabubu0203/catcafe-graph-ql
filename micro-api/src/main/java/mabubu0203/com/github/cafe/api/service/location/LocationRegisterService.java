package mabubu0203.com.github.cafe.api.service.location;

import mabubu0203.com.github.cafe.api.service.location.model.input.LocationRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.location.model.output.LocationServiceOutput;
import mabubu0203.com.github.cafe.common.service.WriteApplicationService;

public interface LocationRegisterService
    extends WriteApplicationService<LocationRegisterServiceInput, LocationServiceOutput> {

}
