package mabubu0203.com.github.cafe.api.controller.cast.helper.response;

import com.netflix.dgs.codegen.types.Cast;
import com.netflix.dgs.codegen.types.CastCat;
import com.netflix.dgs.codegen.types.EmploymentStatus;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.ResponseMapper;

public class CastResponseMapper
    implements ResponseMapper<CastServiceOutput, Cast> {

  @Override
  public Cast apply(CastServiceOutput output) {
    // CastCatは CastCatQueryController.castCat(Cast cast) で生成する
    var castCat = new CastCat.Builder()
        .code(output.castCatCode())
        .build();
    var employmentStatus =
        EmploymentStatus.valueOf(output.employmentStatus());
    return new Cast.Builder()
        .code(output.castCode())
        .locationCode(output.locationCode())
        .castCat(castCat)
        .employmentStatus(employmentStatus)
        .firstAttendanceDate(output.firstAttendanceDate())
        .lastAttendanceDate(output.lastAttendanceDate())
        .memo(output.memo())
        .version(output.version())
        .build();
  }

}


