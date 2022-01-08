package mabubu0203.com.github.cafe.api.service.location;

import mabubu0203.com.github.cafe.api.service.location.model.input.LocationSearchServiceInput;
import mabubu0203.com.github.cafe.api.service.location.model.output.LocationServiceOutput;
import mabubu0203.com.github.cafe.common.service.ReadApplicationService;

public interface LocationSearchService
    extends ReadApplicationService<LocationSearchServiceInput, LocationServiceOutput> {

}
