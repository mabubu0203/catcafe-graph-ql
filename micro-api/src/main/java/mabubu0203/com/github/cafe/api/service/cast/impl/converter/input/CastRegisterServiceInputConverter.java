package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastRegisterServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.input.RegisterServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;

public class CastRegisterServiceInputConverter implements
    RegisterServiceInputConverter<CastRegisterServiceInput, CastEntity> {

  @Override
  public CastEntity apply(CastRegisterServiceInput castRegisterServiceInput) {
    return null;
  }
}
