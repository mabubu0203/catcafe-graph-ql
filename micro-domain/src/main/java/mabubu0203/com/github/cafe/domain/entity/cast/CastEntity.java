package mabubu0203.com.github.cafe.domain.entity.cast;

import java.time.LocalDate;
import java.util.Optional;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.cast.EmploymentStatus;
import mabubu0203.com.github.cafe.domain.value.code.CastCode;
import mabubu0203.com.github.cafe.domain.value.code.CastId;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import mabubu0203.com.github.cafe.domain.value.code.StoreId;

/**
 * キャスト
 */
@Accessors(fluent = true)
@Builder
@Value
@With
public class CastEntity {

  @Deprecated
  CastId castId;
  CastCode castCode;
  @Deprecated
  StoreId storeId;
  LocationCode locationCode;
  EmploymentStatus employmentStatus;
  LocalDate firstAttendanceDate;
  LocalDate lastAttendanceDate;
  Memo memo;
  Integer version;

  @Deprecated
  public Integer getCastIdValue() {
    return Optional.ofNullable(this.castId)
        .map(CastId::value)
        .orElse(null);
  }

  public String getCastCodeValue() {
    return Optional.ofNullable(this.castCode)
        .map(CastCode::value)
        .orElse(null);
  }

  @Deprecated
  public Integer getStoreIdValue() {
    return Optional.ofNullable(this.storeId)
        .map(StoreId::value)
        .orElse(null);
  }

  public String getLocationCodeValue() {
    return Optional.ofNullable(this.locationCode)
        .map(LocationCode::value)
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

  public String getMemoValue() {
    return Optional.ofNullable(this.memo)
        .map(Memo::value)
        .orElse(null);
  }

}
