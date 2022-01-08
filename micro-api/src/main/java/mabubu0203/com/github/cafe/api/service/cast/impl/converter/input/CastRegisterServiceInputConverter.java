package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastRegisterServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.cast.EmploymentStatus;
import mabubu0203.com.github.cafe.domain.value.code.CastCatCode;
import mabubu0203.com.github.cafe.domain.value.code.CastCode;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;

public class CastRegisterServiceInputConverter
    implements ServiceInputConverter<CastRegisterServiceInput, CastEntity> {

  @Override
  public CastEntity apply(CastRegisterServiceInput input) {
    var castCode = CastCode.newCode();
    var locationCode = new LocationCode(input.locationCode());
    var castCatCode = new CastCatCode(input.castCatCode());
    var employmentStatus = EmploymentStatus.getByLabel(input.employmentStatus());
    var memo = new Memo(input.memo());
    var version = Version.empty();
    return CastEntity.builder()
        .castCode(castCode)
        .locationCode(locationCode)
        .castCatCode(castCatCode)
        .employmentStatus(employmentStatus)
        .firstAttendanceDate(input.firstAttendanceDate())
        .lastAttendanceDate(input.lastAttendanceDate())
        .memo(memo)
        .version(version)
        .build();
  }
}
