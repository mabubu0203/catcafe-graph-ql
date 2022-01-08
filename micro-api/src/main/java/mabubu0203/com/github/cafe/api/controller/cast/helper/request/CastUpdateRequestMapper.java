package mabubu0203.com.github.cafe.api.controller.cast.helper.request;

import com.netflix.dgs.codegen.types.CastCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastModifyServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.WriteRequestMapper;

@RequiredArgsConstructor
public class CastUpdateRequestMapper
    implements WriteRequestMapper<CastCommand, CastModifyServiceInput> {

  private final String castCode;
  private final Integer version;

  @Override
  public CastModifyServiceInput apply(CastCommand request) {
    return CastModifyServiceInput.builder()
        .castCode(this.castCode)
        .locationCode(request.getLocationCode())
        .castCatCode(request.getCastCatCode())
        .employmentStatus(request.getEmploymentStatus().name())
        .firstAttendanceDate(request.getFirstAttendanceDate())
        .lastAttendanceDate(request.getLastAttendanceDate())
        .memo(request.getMemo())
        .version(this.version)
        .build();
  }

}
