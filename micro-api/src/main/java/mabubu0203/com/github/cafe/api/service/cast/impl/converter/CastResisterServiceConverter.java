package mabubu0203.com.github.cafe.api.service.cast.impl.converter;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastRegisterServiceOutput;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.cast.EmploymentStatus;
import mabubu0203.com.github.cafe.domain.value.code.CastId;
import mabubu0203.com.github.cafe.domain.value.code.StoreId;

public class CastResisterServiceConverter {

  public CastEntity fromInput(CastRegisterServiceInput input) {
    var castId = CastId.emptyId();
    var storeId = new StoreId(input.getStoreId());
    var employmentStatus = EmploymentStatus.getByLabel(input.getEmploymentStatus());
    var memo = new Memo(input.getMemo());
    var castCatEntity = CastCatEntity.createByCastCatId(input.getCastCatId());
    return CastEntity.builder()
        .castId(castId)
        .storeId(storeId)
        .employmentStatus(employmentStatus)
        .firstAttendanceDate(input.getFirstAttendanceDate())
        .lastAttendanceDate(input.getLastAttendanceDate())
        .memo(memo)
        .createdDateTime(null)
        .version(null)
        .updatedDateTime(null)
        .castCatEntity(castCatEntity)
        .build();
  }

  public CastRegisterServiceOutput toOutput(CastId castId) {
    return CastRegisterServiceOutput.builder()
        .id(castId.value())
        .build();
  }

}
