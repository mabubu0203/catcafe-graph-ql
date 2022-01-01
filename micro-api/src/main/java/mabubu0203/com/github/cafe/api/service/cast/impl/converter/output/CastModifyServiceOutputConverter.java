package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastModifyServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.ServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;

public class CastModifyServiceOutputConverter implements
    ServiceOutputConverter<CastEntity, CastModifyServiceOutput> {

  @Override
  public CastModifyServiceOutput apply(CastEntity cast) {
    return CastModifyServiceOutput.builder()
        .castCode(cast.getCastCodeValue())
        .build();
  }

}
