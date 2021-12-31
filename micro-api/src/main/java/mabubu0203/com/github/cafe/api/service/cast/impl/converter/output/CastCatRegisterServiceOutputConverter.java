package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import com.netflix.dgs.codegen.types.CastCat;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatRegisterServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.RegisterServiceOutputConverter;

public class CastCatRegisterServiceOutputConverter implements
    RegisterServiceOutputConverter<CastCat, CastCatRegisterServiceOutput> {

  @Override
  public CastCatRegisterServiceOutput apply(CastCat castCat) {
    return CastCatRegisterServiceOutput.builder()
        .code(castCat.getCode())
        .build();
  }
}
