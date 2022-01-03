package mabubu0203.com.github.cafe.api.service.location.impl.converter.input;

import java.util.Optional;
import mabubu0203.com.github.cafe.api.service.location.model.input.LocationSearchServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.location.LocationSearchConditions;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;

public class LocationSearchServiceInputConverter
    implements ServiceInputConverter<LocationSearchServiceInput, LocationSearchConditions> {

  @Override
  public LocationSearchConditions apply(LocationSearchServiceInput input) {
    var locationCodes = input.locationCodes()
        .stream()
        .map(LocationCode::new)
        .toList();
    return new LocationSearchConditions(
        Optional.ofNullable(locationCodes));
  }
}
