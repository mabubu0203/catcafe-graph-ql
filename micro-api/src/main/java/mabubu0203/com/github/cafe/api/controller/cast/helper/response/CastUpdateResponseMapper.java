package mabubu0203.com.github.cafe.api.controller.cast.helper.response;

import com.netflix.dgs.codegen.types.Cast;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastModifyServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.UpdateResponseMapper;

public class CastUpdateResponseMapper implements
    UpdateResponseMapper<CastModifyServiceOutput, Cast> {

  @Override
  public Cast apply(CastModifyServiceOutput castModifyServiceOutput) {
    return new Cast();
  }

}
