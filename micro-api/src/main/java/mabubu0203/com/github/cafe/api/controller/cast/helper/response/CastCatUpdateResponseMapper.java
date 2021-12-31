package mabubu0203.com.github.cafe.api.controller.cast.helper.response;

import com.netflix.dgs.codegen.types.CastCat;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatModifyServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.UpdateResponseMapper;

public class CastCatUpdateResponseMapper implements
    UpdateResponseMapper<CastCatModifyServiceOutput, CastCat> {

  @Override
  public CastCat apply(CastCatModifyServiceOutput output) {
    return new CastCat();
  }
}
