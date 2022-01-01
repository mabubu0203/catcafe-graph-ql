package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastRegisterServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.RegisterServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;

public class CastRegisterServiceOutputConverter implements
    RegisterServiceOutputConverter<CastEntity, CastRegisterServiceOutput> {

  @Override
  public CastRegisterServiceOutput apply(CastEntity cast) {
    return CastRegisterServiceOutput.builder()
        .code(cast.getCastCodeValue())
        .build();
  }
}
