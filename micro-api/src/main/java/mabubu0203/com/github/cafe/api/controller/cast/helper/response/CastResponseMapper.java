package mabubu0203.com.github.cafe.api.controller.cast.helper.response;

import com.netflix.dgs.codegen.types.Cast;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.ResponseMapper;

public class CastResponseMapper
    implements ResponseMapper<CastServiceOutput, Cast> {

  @Override
  public Cast apply(CastServiceOutput output) {
    return new Cast();
  }

}


