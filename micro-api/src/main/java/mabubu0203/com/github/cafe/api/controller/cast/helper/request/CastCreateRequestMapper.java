package mabubu0203.com.github.cafe.api.controller.cast.helper.request;

import com.netflix.dgs.codegen.types.CastCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastRegisterServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.CreateRequestMapper;

@RequiredArgsConstructor
public class CastCreateRequestMapper implements
    CreateRequestMapper<CastCommand, CastRegisterServiceInput> {

  @Override
  public CastRegisterServiceInput apply(CastCommand request) {
    return CastRegisterServiceInput.builder()
        .castCatCode("")
        .locationCode("")
        .employmentStatus(request.getEmploymentStatus().name())
        .firstAttendanceDate(request.getFirstAttendanceDate())
        .lastAttendanceDate(request.getLastAttendanceDate())
        .memo(request.getMemo())
        .build();
  }

}
