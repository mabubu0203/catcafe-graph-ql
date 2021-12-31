package mabubu0203.com.github.cafe.api.controller.cast.helper.response;

import com.netflix.dgs.codegen.types.CastCat;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatResisterServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.CreateResponseMapper;

public class CastCatCreateResponseMapper implements
    CreateResponseMapper<CastCatResisterServiceOutput, CastCat> {

  @Override
  public CastCat apply(CastCatResisterServiceOutput castCatResisterServiceOutput) {
    return new CastCat();
  }

}
