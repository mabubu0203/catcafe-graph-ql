package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatSearchServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.input.SearchServiceInputConverter;

public class CastCatSearchServiceInputConverter implements
    SearchServiceInputConverter<CastCatSearchServiceInput, String> {

  @Override
  public String apply(CastCatSearchServiceInput input) {
    return input.optCastCatCodes().get().stream().findFirst().get();
  }

}
