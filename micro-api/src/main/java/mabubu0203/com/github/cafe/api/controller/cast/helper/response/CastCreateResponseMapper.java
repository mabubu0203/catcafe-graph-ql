package mabubu0203.com.github.cafe.api.controller.cast.helper.response;

import com.netflix.dgs.codegen.types.Cast;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastRegisterServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.CreateResponseMapper;

public class CastCreateResponseMapper implements
    CreateResponseMapper<CastRegisterServiceOutput, Cast> {

  @Override
  public Cast apply(CastRegisterServiceOutput output) {
    return new Cast();
  }

}
