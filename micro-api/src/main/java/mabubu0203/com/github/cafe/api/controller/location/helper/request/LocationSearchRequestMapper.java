package mabubu0203.com.github.cafe.api.controller.location.helper.request;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.location.model.input.LocationSearchServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.ReadRequestMapper;

@RequiredArgsConstructor
public class LocationSearchRequestMapper
    implements ReadRequestMapper<LocationSearchServiceInput> {

  private final List<String> locationCodes;

  @Override
  public LocationSearchServiceInput get() {
    return LocationSearchServiceInput.builder()
        .locationCodes(this.locationCodes)
        .build();
  }

}
