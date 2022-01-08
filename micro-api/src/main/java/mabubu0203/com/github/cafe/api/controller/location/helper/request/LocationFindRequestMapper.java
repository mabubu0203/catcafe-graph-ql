package mabubu0203.com.github.cafe.api.controller.location.helper.request;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.location.model.input.LocationSearchServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.ReadRequestMapper;

@RequiredArgsConstructor
public class LocationFindRequestMapper
    implements ReadRequestMapper<LocationSearchServiceInput> {

  private final String locationCode;

  @Override
  public LocationSearchServiceInput get() {
    var locationCodes = new ArrayList<String>();
    locationCodes.add(this.locationCode);
    return LocationSearchServiceInput.builder()
        .locationCodes(locationCodes)
        .build();
  }

}
