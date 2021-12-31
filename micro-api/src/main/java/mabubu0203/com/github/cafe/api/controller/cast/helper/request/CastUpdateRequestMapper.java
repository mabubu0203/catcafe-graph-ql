package mabubu0203.com.github.cafe.api.controller.cast.helper.request;

import com.netflix.dgs.codegen.types.CastCommand;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastModifyServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.UpdateRequestMapper;

public class CastUpdateRequestMapper implements
    UpdateRequestMapper<CastCommand, CastModifyServiceInput> {

  @Override
  public CastModifyServiceInput apply(CastCommand request) {
    return null;
  }

}
