package mabubu0203.com.github.cafe.domain.entity.cast;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.cast.EmploymentStatus;
import mabubu0203.com.github.cafe.domain.value.code.CastCatId;
import mabubu0203.com.github.cafe.domain.value.code.CastId;
import mabubu0203.com.github.cafe.domain.value.code.StoreId;

/**
 * キャスト
 */
@Builder
@Value
@With
public class CastEntity {

  CastId castId;
  StoreId storeId;
  EmploymentStatus employmentStatus;
  LocalDate firstAttendanceDate;
  LocalDate lastAttendanceDate;
  Memo memo;
  LocalDateTime createdDateTime;
  Integer version;
  LocalDateTime updatedDateTime;
  CastCatEntity castCatEntity;

  public Integer getCastIdValue() {
    return Optional.ofNullable(this.castId)
        .map(CastId::value)
        .orElse(null);
  }

  public Integer getStoreIdValue() {
    return Optional.ofNullable(this.storeId)
        .map(StoreId::value)
        .orElse(null);
  }

  public Integer getEmploymentStatusCode() {
    return Optional.ofNullable(this.employmentStatus)
        .map(EmploymentStatus::getCode)
        .orElse(null);
  }

  public String getEmploymentStatusLabel() {
    return Optional.ofNullable(this.employmentStatus)
        .map(EmploymentStatus::getLabel)
        .orElse(null);
  }

  public Integer getCastCatIdValue() {
    return Optional.ofNullable(this.castCatEntity)
        .map(CastCatEntity::getCastCatId)
        .map(CastCatId::value)
        .orElse(null);
  }

  public String getMemoValue() {
    return Optional.ofNullable(this.memo)
        .map(Memo::value)
        .orElse(null);
  }

}
