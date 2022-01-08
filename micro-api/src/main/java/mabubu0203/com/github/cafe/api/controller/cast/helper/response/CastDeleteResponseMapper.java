package mabubu0203.com.github.cafe.api.controller.cast.helper.response;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastDeleteServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.DeleteResponseMapper;

public class CastDeleteResponseMapper
    implements DeleteResponseMapper<CastDeleteServiceOutput, String> {

  @Override
  public String apply(CastDeleteServiceOutput output) {
    return output.castCode();
  }
}
