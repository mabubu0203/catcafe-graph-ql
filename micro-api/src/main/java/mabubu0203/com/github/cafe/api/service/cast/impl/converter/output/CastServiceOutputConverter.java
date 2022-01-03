package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;

public class CastServiceOutputConverter
    implements ServiceOutputConverter<CastEntity, CastServiceOutput> {

  @Override
  public CastServiceOutput apply(CastEntity cast) {
    return CastServiceOutput.builder()
        .castCode(cast.getCastCodeValue())
        .locationCode(cast.getLocationCodeValue())
        .castCatCode(cast.getCastCatCodeValue())
        .employmentStatus(cast.getEmploymentStatusLabel())
        .firstAttendanceDate(cast.firstAttendanceDate())
        .lastAttendanceDate(cast.lastAttendanceDate())
        .memo(cast.getMemoValue())
        .version(cast.getVersionValue())
        .build();
  }

}
