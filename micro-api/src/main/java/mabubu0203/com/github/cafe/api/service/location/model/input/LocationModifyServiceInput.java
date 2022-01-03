package mabubu0203.com.github.cafe.api.service.location.model.input;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

@Accessors(fluent = true)
@Builder
@Value
public class LocationModifyServiceInput implements ServiceInput {

  String locationCode;
  String name;
  ContactObject contact;
  AddressObject address;
  LocalDate openDate;
  LocalDate closeDate;
  HoursObject hours;
  String memo;
  Integer version;

  @Accessors(fluent = true)
  @Builder
  @Value
  public static class ContactObject {

    String phoneNumber;
    String mailAddress;

  }

  @Accessors(fluent = true)
  @Builder
  @Value
  public static class AddressObject {

    String postalCode;
    Integer prefectureCode;
    String address1;
    String address2;
    String address3;
    String streetAddress;
    String buildingName;
    String supplement;

  }

  @Accessors(fluent = true)
  @Builder
  @Value
  public static class HoursObject {

    LocalTime openingTime;
    LocalTime closingTime;
    String supplement;

  }

}
