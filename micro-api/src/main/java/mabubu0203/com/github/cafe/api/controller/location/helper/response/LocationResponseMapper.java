package mabubu0203.com.github.cafe.api.controller.location.helper.response;

import com.netflix.dgs.codegen.types.Location;
import com.netflix.dgs.codegen.types.LocationAddress;
import com.netflix.dgs.codegen.types.LocationContact;
import com.netflix.dgs.codegen.types.LocationHours;
import mabubu0203.com.github.cafe.api.service.location.model.output.LocationServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.ResponseMapper;

public class LocationResponseMapper
    implements ResponseMapper<LocationServiceOutput, Location> {

  @Override
  public Location apply(LocationServiceOutput output) {
    return new Location.Builder()
        .code(output.locationCode())
        .name(output.name())
        .contact(this.contact(output.contact()))
        .address(this.address(output.address()))
        .openDate(output.openDate())
        .closeDate(output.closeDate())
        .hours(this.hours(output.hours()))
        .memo(output.memo())
        .version(output.version())
        .build();
  }

  private LocationContact contact(LocationServiceOutput.ContactObject object) {
    return new LocationContact.Builder()
        .phoneNumber(object.phoneNumber())
        .mailAddress(object.mailAddress())
        .build();
  }

  private LocationAddress address(LocationServiceOutput.AddressObject object) {
    return new LocationAddress.Builder()
        .postalCode(object.postalCode())
        .prefectureCode(object.prefectureCode())
        .prefectureLabel(object.prefectureLabel())
        .address1(object.address1())
        .address2(object.address2())
        .address3(object.address3())
        .streetAddress(object.streetAddress())
        .buildingName(object.buildingName())
        .supplement(object.supplement())
        .build();
  }

  private LocationHours hours(LocationServiceOutput.HoursObject object) {

//    Optional.ofNullable(object.getOpeningTime())
//        .map(lt -> lt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)))
//        .ifPresent(hours::setOpeningTime);
//    Optional.ofNullable(object.getClosingTime())
//        .map(lt -> lt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)))
//        .ifPresent(hours::setClosingTime);

    return new LocationHours.Builder()
        .supplement(object.supplement())
        .build();
  }

}
