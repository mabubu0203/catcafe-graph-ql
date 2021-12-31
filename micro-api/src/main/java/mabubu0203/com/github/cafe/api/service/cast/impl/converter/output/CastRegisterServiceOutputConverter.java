package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastRegisterServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.RegisterServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.value.code.CastCode;

public class CastRegisterServiceOutputConverter implements
    RegisterServiceOutputConverter<CastCode, CastRegisterServiceOutput> {

  @Override
  public CastRegisterServiceOutput apply(CastCode castCode) {
    return CastRegisterServiceOutput.builder()
        .code(castCode.value())
        .build();
  }
}
