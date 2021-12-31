package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastRegisterServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.RegisterServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.value.code.CastId;

public class CastRegisterServiceOutputConverter implements
    RegisterServiceOutputConverter<CastId, CastRegisterServiceOutput> {

  @Override
  public CastRegisterServiceOutput apply(CastId castId) {
    return null;
  }
}
