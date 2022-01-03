package mabubu0203.com.github.cafe.api.service.location.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.location.model.output.LocationDeleteServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;

public class LocationDeleteServiceOutputConverter
    implements ServiceOutputConverter<LocationCode, LocationDeleteServiceOutput> {

  @Override
  public LocationDeleteServiceOutput apply(LocationCode locationCode) {
    return LocationDeleteServiceOutput.builder()
        .build();
  }

}
