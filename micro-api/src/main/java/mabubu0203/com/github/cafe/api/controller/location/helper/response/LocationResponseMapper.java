package mabubu0203.com.github.cafe.api.controller.location.helper.response;

import com.netflix.dgs.codegen.types.Location;
import mabubu0203.com.github.cafe.api.service.location.model.output.LocationServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.ResponseMapper;

public class LocationResponseMapper
    implements ResponseMapper<LocationServiceOutput, Location> {

  @Override
  public Location apply(LocationServiceOutput output) {
    return new Location.Builder()
        .code(output.locationCode())
        .memo(output.memo())
        .version(output.version())
        .build();
  }

}
