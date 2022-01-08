package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import java.util.Optional;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastSearchServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastSearchConditions;
import mabubu0203.com.github.cafe.domain.value.code.CastCode;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;

public class CastSearchServiceInputConverter
    implements ServiceInputConverter<CastSearchServiceInput, CastSearchConditions> {

  @Override
  public CastSearchConditions apply(CastSearchServiceInput input) {
    var castCodes = input.castCodes()
        .stream()
        .map(CastCode::new)
        .toList();
    var locationCodes = input.locationCodes()
        .stream()
        .map(LocationCode::new)
        .toList();
    return new CastSearchConditions(
        Optional.ofNullable(castCodes),
        Optional.ofNullable(locationCodes));
  }
}
