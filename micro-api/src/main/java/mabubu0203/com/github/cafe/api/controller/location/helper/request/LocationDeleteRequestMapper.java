package mabubu0203.com.github.cafe.api.controller.location.helper.request;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.location.model.input.LocationDeleteServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.WriteRequestMapper;

@RequiredArgsConstructor
public class LocationDeleteRequestMapper
    implements WriteRequestMapper<String, LocationDeleteServiceInput> {

  private final Integer version;

  @Override
  public LocationDeleteServiceInput apply(String locationCode) {
    return LocationDeleteServiceInput.builder()
        .locationCode(locationCode)
        .version(this.version)
        .build();
  }

}
