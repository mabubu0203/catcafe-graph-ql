package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastDeleteServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.input.DeleteServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;
import mabubu0203.com.github.cafe.domain.value.code.CastCode;

public class CastDeleteServiceInputConverter implements
    DeleteServiceInputConverter<CastDeleteServiceInput, CastEntity> {

  @Override
  public CastEntity apply(CastDeleteServiceInput input) {
    var castCode = new CastCode(input.castCode());
    return CastEntity.builder()
        .castCode(castCode)
        .version(input.version())
        .build();
  }

}
