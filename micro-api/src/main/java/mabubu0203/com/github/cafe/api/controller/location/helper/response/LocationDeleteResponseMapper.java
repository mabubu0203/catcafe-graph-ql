package mabubu0203.com.github.cafe.api.controller.location.helper.response;

import mabubu0203.com.github.cafe.api.service.location.model.output.LocationDeleteServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.DeleteResponseMapper;

public class LocationDeleteResponseMapper
    implements DeleteResponseMapper<LocationDeleteServiceOutput, String> {

  @Override
  public String apply(LocationDeleteServiceOutput output) {
    return output.locationCode();
  }

}
