package mabubu0203.com.github.cafe.api.controller.cast.helper.response;

import com.netflix.dgs.codegen.types.CastCat;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatRegisterServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.CreateResponseMapper;

public class CastCatCreateResponseMapper implements
    CreateResponseMapper<CastCatRegisterServiceOutput, CastCat> {

  @Override
  public CastCat apply(CastCatRegisterServiceOutput castCatResisterServiceOutput) {
    return new CastCat();
  }

}
