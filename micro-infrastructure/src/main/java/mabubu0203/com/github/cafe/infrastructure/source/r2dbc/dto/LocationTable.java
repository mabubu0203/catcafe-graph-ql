package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import mabubu0203.com.github.cafe.domain.entity.location.LocationEntity;
import mabubu0203.com.github.cafe.domain.value.MailAddress;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.PhoneNumber;
import mabubu0203.com.github.cafe.domain.value.PostalCode;
import mabubu0203.com.github.cafe.domain.value.Prefecture;
import mabubu0203.com.github.cafe.domain.value.Supplement;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Accessors(fluent = true)
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(value = "location")
public class LocationTable extends BaseTable<Integer> {

  @Id
  @Column(value = "id")
  private Integer id;

  @Column(value = "name")
  private String name;

  @Column(value = "phone_number")
  private String phoneNumber;

  @Column(value = "mail_address")
  private String mailAddress;

  @Column(value = "postal_code")
  private String postalCode;

  @Column(value = "prefecture_code")
  private int prefectureCode;

  @Column(value = "address_1")
  private String address1;

  @Column(value = "address_2")
  private String address2;

  @Column(value = "address_3")
  private String address3;

  @Column(value = "street_address")
  private String streetAddress;

  @Column(value = "building_name")
  private String buildingName;

  @Column(value = "address_supplement")
  private String addressSupplement;

  @Column(value = "open_date")
  private LocalDate openDate;

  @Column(value = "close_date")
  private LocalDate closeDate;

  @Column(value = "opening_time")
  private LocalTime openingTime;

  @Column(value = "closing_time")
  private LocalTime closingTime;

  @Column(value = "hours_supplement")
  private String hoursSupplement;

  @Column(value = "memo")
  private String memo;

  @Override
  public Integer getId() {
    return this.id;
  }

  @Override
  @Transient
  public boolean isNew() {
    return super.isNew() || Objects.isNull(this.id);
  }

  @Override
  @Transient
  public LocationTable code(String code) {
    super.code(code);
    return this;
  }

  @Override
  @Transient
  public LocationTable createdBy(Integer createdBy) {
    super.createdBy(createdBy);
    return this;
  }

  @Override
  @Transient
  public LocationTable version(Integer version) {
    super.version(version);
    return this;
  }

  @Override
  @Transient
  public LocationTable updatedBy(Integer updatedBy) {
    super.updatedBy(updatedBy);
    return this;
  }

  public LocationTable attach(LocationEntity entity) {
    return code(entity.getLocationCodeValue())
        .name(entity.name())
        .phoneNumber(entity.getPhoneNumberValue())
        .mailAddress(entity.getMailAddressValue())
        .postalCode(entity.getPostalCodeValue())
        .prefectureCode(entity.getPrefectureCode())
        .address1(entity.address1())
        .address2(entity.address2())
        .address3(entity.address3())
        .streetAddress(entity.streetAddress())
        .buildingName(entity.buildingName())
        .addressSupplement(entity.getAddressSupplementValue())
        .openDate(entity.openDate())
        .closeDate(entity.closeDate())
        .openingTime(entity.openingTime())
        .closingTime(entity.closingTime())
        .hoursSupplement(entity.getHoursSupplementValue())
        .memo(entity.getMemoValue())
        .version(entity.getVersionValue());
  }

  public LocationEntity toEntity() {
    var locationCode = new LocationCode(super.code());
    var phoneNumber = new PhoneNumber(this.phoneNumber);
    var mailAddress = new MailAddress(this.mailAddress);
    var postalCode = new PostalCode(this.postalCode);
    var prefecture = Prefecture.getByCode(this.prefectureCode);
    var addressSupplement = new Supplement(this.addressSupplement);
    var hoursSupplement = new Supplement(this.hoursSupplement);
    var locationMemo = new Memo(this.memo);
    var version = new Version(super.version());
    return LocationEntity.builder()
        .locationCode(locationCode)
        .name(this.name)
        .phoneNumber(phoneNumber)
        .mailAddress(mailAddress)
        .postalCode(postalCode)
        .prefecture(prefecture)
        .address1(this.address1)
        .address2(this.address2)
        .address3(this.address3)
        .streetAddress(this.streetAddress)
        .buildingName(this.buildingName)
        .addressSupplement(addressSupplement)
        .openDate(this.openDate)
        .closeDate(this.closeDate)
        .openingTime(this.openingTime)
        .closingTime(this.closingTime)
        .hoursSupplement(hoursSupplement)
        .memo(locationMemo)
        .version(version)
        .build();
  }

}
