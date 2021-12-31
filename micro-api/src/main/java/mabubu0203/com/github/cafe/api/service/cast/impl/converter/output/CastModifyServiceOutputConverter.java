package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import com.netflix.dgs.codegen.types.Cast;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastModifyServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.ModifyServiceOutputConverter;

public class CastModifyServiceOutputConverter implements
    ModifyServiceOutputConverter<Cast, CastModifyServiceOutput> {

  @Override
  public CastModifyServiceOutput apply(Cast cast) {
    return CastModifyServiceOutput.builder()
        .code(cast.getCode())
        .build();
  }

}
