package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import com.netflix.dgs.codegen.types.CastCat;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatModifyServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.ModifyServiceOutputConverter;

public class CastCatModifyServiceOutputConverter implements
    ModifyServiceOutputConverter<CastCat, CastCatModifyServiceOutput> {

  @Override
  public CastCatModifyServiceOutput apply(CastCat castCat) {
    return CastCatModifyServiceOutput.builder()
        .code(castCat.getCode())
        .build();
  }

}
