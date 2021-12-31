package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastDeleteServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.DeleteServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.value.code.CastCode;

public class CastDeleteServiceOutputConverter implements
    DeleteServiceOutputConverter<CastCode, CastDeleteServiceOutput> {

  @Override
  public CastDeleteServiceOutput apply(CastCode castCode) {
    return CastDeleteServiceOutput.builder()
        .code(castCode.value())
        .build();
  }

}
