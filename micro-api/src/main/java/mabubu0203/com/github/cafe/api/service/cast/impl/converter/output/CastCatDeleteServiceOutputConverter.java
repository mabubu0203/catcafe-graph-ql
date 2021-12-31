package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatDeleteServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.DeleteServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.value.code.CastCatCode;

public class CastCatDeleteServiceOutputConverter implements
    DeleteServiceOutputConverter<CastCatCode, CastCatDeleteServiceOutput> {

  @Override
  public CastCatDeleteServiceOutput apply(CastCatCode castCatCode) {
    return CastCatDeleteServiceOutput.builder()
        .code(castCatCode.value())
        .build();
  }

}
