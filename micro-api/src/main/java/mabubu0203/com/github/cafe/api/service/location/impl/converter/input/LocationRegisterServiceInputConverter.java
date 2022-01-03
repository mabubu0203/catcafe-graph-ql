package mabubu0203.com.github.cafe.api.service.location.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.location.model.input.LocationRegisterServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.location.LocationEntity;

public class LocationRegisterServiceInputConverter
    implements ServiceInputConverter<LocationRegisterServiceInput, LocationEntity> {

  @Override
  public LocationEntity apply(LocationRegisterServiceInput input) {
    return null;
  }

}
