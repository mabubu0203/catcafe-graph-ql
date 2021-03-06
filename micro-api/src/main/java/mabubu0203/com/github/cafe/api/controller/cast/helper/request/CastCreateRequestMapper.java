package mabubu0203.com.github.cafe.api.controller.cast.helper.request;

import com.netflix.dgs.codegen.types.CastCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastRegisterServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.WriteRequestMapper;

@RequiredArgsConstructor
public class CastCreateRequestMapper
    implements WriteRequestMapper<CastCommand, CastRegisterServiceInput> {

  @Override
  public CastRegisterServiceInput apply(CastCommand request) {
    return CastRegisterServiceInput.builder()
        .locationCode(request.getLocationCode())
        .castCatCode(request.getCastCatCode())
        .employmentStatus(request.getEmploymentStatus().name())
        .firstAttendanceDate(request.getFirstAttendanceDate())
        .lastAttendanceDate(request.getLastAttendanceDate())
        .memo(request.getMemo())
        .build();
  }

}
