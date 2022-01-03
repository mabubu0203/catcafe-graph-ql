package mabubu0203.com.github.cafe.api.service.location.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.location.model.output.LocationServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.entity.location.LocationEntity;

public class LocationServiceOutputConverter
    implements ServiceOutputConverter<LocationEntity, LocationServiceOutput> {

  @Override
  public LocationServiceOutput apply(LocationEntity locationEntity) {
    return LocationServiceOutput.builder()
        .build();
  }

}
