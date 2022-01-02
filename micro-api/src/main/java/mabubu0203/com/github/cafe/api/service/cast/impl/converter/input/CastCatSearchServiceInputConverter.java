package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import java.util.Optional;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatSearchServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatSearchConditions;
import mabubu0203.com.github.cafe.domain.value.code.CastCatCode;

public class CastCatSearchServiceInputConverter
    implements ServiceInputConverter<CastCatSearchServiceInput, CastCatSearchConditions> {

  @Override
  public CastCatSearchConditions apply(CastCatSearchServiceInput input) {
    var castCatCodes = input.castCatCodes()
        .stream()
        .map(CastCatCode::new)
        .toList();
    return new CastCatSearchConditions(Optional.ofNullable(castCatCodes));
  }

}
