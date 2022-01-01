package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastRegisterServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.input.RegisterServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.cast.EmploymentStatus;
import mabubu0203.com.github.cafe.domain.value.code.CastCode;

public class CastRegisterServiceInputConverter implements
    RegisterServiceInputConverter<CastRegisterServiceInput, CastEntity> {

  @Override
  public CastEntity apply(CastRegisterServiceInput input) {
    var castCode = CastCode.newCode();
    var employmentStatus = EmploymentStatus.getByLabel(input.employmentStatus());
    var memo = new Memo(input.memo());
    var castCatEntity = CastCatEntity.createByCastCatCode(input.castCatCode());
    return CastEntity.builder()
        .castCode(castCode)
        .locationCode(null)
        .employmentStatus(employmentStatus)
        .firstAttendanceDate(input.firstAttendanceDate())
        .lastAttendanceDate(input.lastAttendanceDate())
        .memo(memo)
        .version(null)
        .castCatEntity(castCatEntity)
        .build();
  }
}
