package mabubu0203.com.github.cafe.domain.entity.location;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.domain.value.MailAddress;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.PhoneNumber;
import mabubu0203.com.github.cafe.domain.value.PostalCode;
import mabubu0203.com.github.cafe.domain.value.Prefecture;
import mabubu0203.com.github.cafe.domain.value.Supplement;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;

/**
 * 所在地/店舗
 */
@Accessors(fluent = true)
@Builder
@Value
@With
public class LocationEntity {

  LocationCode locationCode;
  String name;
  PhoneNumber phoneNumber;
  MailAddress mailAddress;
  PostalCode postalCode;
  Prefecture prefecture;
  String address1;
  String address2;
  String address3;
  String streetAddress;
  String buildingName;
  Supplement addressSupplement;
  LocalDate openDate;
  LocalDate closeDate;
  LocalTime openingTime;
  LocalTime closingTime;
  Supplement hoursSupplement;
  Memo memo;
  Version version;

  public String getLocationCodeValue() {
    return Optional.ofNullable(this.locationCode)
        .map(LocationCode::value)
        .orElse(null);
  }

  public String getPhoneNumberValue() {
    return Optional.ofNullable(this.phoneNumber)
        .map(PhoneNumber::value)
        .orElse(null);
  }

  public String getMailAddressValue() {
    return Optional.ofNullable(this.mailAddress)
        .map(MailAddress::value)
        .orElse(null);
  }

  public String getPostalCodeValue() {
    return Optional.ofNullable(this.postalCode)
        .map(PostalCode::value)
        .orElse(null);
  }

  public Integer getPrefectureCode() {
    return Optional.ofNullable(this.prefecture)
        .map(Prefecture::getCode)
        .orElse(null);
  }

  public String getPrefectureLabel() {
    return Optional.ofNullable(this.prefecture)
        .map(Prefecture::getLabel)
        .orElse(null);
  }

  public String getAddressSupplementValue() {
    return Optional.ofNullable(this.addressSupplement)
        .map(Supplement::value)
        .orElse(null);
  }

  public String getHoursSupplementValue() {
    return Optional.ofNullable(this.hoursSupplement)
        .map(Supplement::value)
        .orElse(null);
  }

  public String getMemoValue() {
    return Optional.ofNullable(this.memo)
        .map(Memo::value)
        .orElse(null);
  }

  public Integer getVersionValue() {
    return Optional.ofNullable(this.version)
        .map(Version::value)
        .orElse(null);
  }

}
