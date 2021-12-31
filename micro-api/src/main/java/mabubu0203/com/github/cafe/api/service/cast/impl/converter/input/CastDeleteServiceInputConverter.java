package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastDeleteServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.input.DeleteServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;

public class CastDeleteServiceInputConverter implements
    DeleteServiceInputConverter<CastDeleteServiceInput, CastEntity> {

  @Override
  public CastEntity apply(CastDeleteServiceInput castDeleteServiceInput) {
    return null;
  }

}
