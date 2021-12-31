package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastDeleteServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.DeleteServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.value.code.CastId;

public class CastDeleteServiceOutputConverter implements
    DeleteServiceOutputConverter<CastId, CastDeleteServiceOutput> {

  @Override
  public CastDeleteServiceOutput apply(CastId castId) {
    return null;
  }

}
