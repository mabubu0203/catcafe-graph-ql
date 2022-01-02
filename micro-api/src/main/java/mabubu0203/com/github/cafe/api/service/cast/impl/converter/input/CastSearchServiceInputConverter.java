package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastSearchServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastSearchConditions;

public class CastSearchServiceInputConverter
    implements ServiceInputConverter<CastSearchServiceInput, CastSearchConditions> {

  @Override
  public CastSearchConditions apply(CastSearchServiceInput castSearchServiceInput) {
    return new CastSearchConditions(null, null);
  }
}
