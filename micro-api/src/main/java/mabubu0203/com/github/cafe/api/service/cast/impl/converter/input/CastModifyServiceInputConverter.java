package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastModifyServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.input.ModifyServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;

public class CastModifyServiceInputConverter implements
    ModifyServiceInputConverter<CastModifyServiceInput, CastEntity> {

  @Override
  public CastEntity apply(CastModifyServiceInput castModifyServiceInput) {
    return null;
  }

}
