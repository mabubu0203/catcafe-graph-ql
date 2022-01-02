package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;

public class CastServiceOutputConverter implements
    ServiceOutputConverter<CastEntity, CastServiceOutput> {

  @Override
  public CastServiceOutput apply(CastEntity castEntity) {
    return CastServiceOutput.builder().build();
  }
}
