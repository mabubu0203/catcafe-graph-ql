package mabubu0203.com.github.cafe.api.controller.cast.helper.response;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatDeleteServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.DeleteResponseMapper;

public class CastCatDeleteResponseMapper implements
    DeleteResponseMapper<CastCatDeleteServiceOutput, String> {

  @Override
  public String apply(CastCatDeleteServiceOutput output) {
    return "";
  }
}
