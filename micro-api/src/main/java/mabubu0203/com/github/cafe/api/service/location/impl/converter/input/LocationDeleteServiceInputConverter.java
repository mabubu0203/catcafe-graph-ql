package mabubu0203.com.github.cafe.api.service.location.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.location.model.input.LocationDeleteServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.location.LocationEntity;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;

public class LocationDeleteServiceInputConverter
    implements ServiceInputConverter<LocationDeleteServiceInput, LocationEntity> {

  @Override
  public LocationEntity apply(LocationDeleteServiceInput input) {
    var locationCode = new LocationCode(input.locationCode());
    var version = new Version(input.version());
    return LocationEntity.builder()
        .locationCode(locationCode)
        .version(version)
        .build();
  }

}
