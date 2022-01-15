package mabubu0203.com.github.cafe.infrastructure.source.elastic.dto;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.source.elastic.base.BaseDocument;
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
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Accessors(fluent = true)
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Document(indexName = "location")
public class LocationDocument extends BaseDocument<String> {


  @Id
  private String id;

  @Field(name = "name", type = FieldType.Text)
  private String name;

  @Field(name = "phone_number", type = FieldType.Text)
  private String phoneNumber;

  @Field(name = "mail_address", type = FieldType.Text)
  private String mailAddress;

  @Field(name = "postal_code", type = FieldType.Text)
  private String postalCode;

  @Field(name = "prefecture_code", type = FieldType.Integer)
  private Integer prefectureCode;

  @Field(name = "address_1", type = FieldType.Text)
  private String address1;

  @Field(name = "address_2", type = FieldType.Text)
  private String address2;

  @Field(name = "address_3", type = FieldType.Text)
  private String address3;

  @Field(name = "street_address", type = FieldType.Text)
  private String streetAddress;

  @Field(name = "building_name", type = FieldType.Text)
  private String buildingName;

  @Field(name = "address_supplement", type = FieldType.Text)
  private String addressSupplement;

  @Field(name = "open_date",
      type = FieldType.Date, format = DateFormat.basic_date)
  private Instant openDate;

  @Field(name = "close_date",
      type = FieldType.Date, format = DateFormat.basic_date)
  private Instant closeDate;

  @Field(name = "opening_time",
      type = FieldType.Date, format = DateFormat.basic_date_time)
  private LocalTime openingTime;

  @Field(name = "closing_time",
      type = FieldType.Date, format = DateFormat.basic_date_time)
  private Instant closingTime;

  @Field(name = "hours_supplement",
      type = FieldType.Text)
  private String hoursSupplement;

  @Field(name = "memo", type = FieldType.Text)
  private String memo;

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  @Transient
  public boolean isNew() {
    return super.isNew() || Objects.isNull(this.id);
  }

  @Override
  @Transient
  public LocationDocument code(String code) {
    super.code(code);
    return this;
  }

  @Override
  @Transient
  public LocationDocument version(Integer version) {
    super.version(version);
    return this;
  }

  public LocationDocument attach(LocationEntity entity) {
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
//        .openDate(entity.openDate())
//        .closeDate(entity.closeDate())
//        .openingTime(entity.openingTime())
//        .closingTime(entity.closingTime())
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
//        .openDate(this.openDate)
//        .closeDate(this.closeDate)
//        .openingTime(this.openingTime)
//        .closingTime(this.closingTime)
        .hoursSupplement(hoursSupplement)
        .memo(locationMemo)
        .version(version)
        .build();
  }

}
