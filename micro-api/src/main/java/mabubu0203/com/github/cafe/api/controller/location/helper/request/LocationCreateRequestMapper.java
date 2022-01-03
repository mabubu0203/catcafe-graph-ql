package mabubu0203.com.github.cafe.api.controller.location.helper.request;

import com.netflix.dgs.codegen.types.LocationCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.location.model.input.LocationRegisterServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.WriteRequestMapper;

@RequiredArgsConstructor
public class LocationCreateRequestMapper
    implements WriteRequestMapper<LocationCommand, LocationRegisterServiceInput> {

  @Override
  public LocationRegisterServiceInput apply(LocationCommand request) {
    var contact = request.getContact();
    var contactObject = LocationRegisterServiceInput.ContactObject.builder()
        .phoneNumber(contact.getPhoneNumber())
        .mailAddress(contact.getMailAddress())
        .build();
    var address = request.getAddress();
    var addressObject = LocationRegisterServiceInput.AddressObject.builder()
        .postalCode(address.getPostalCode())
        .prefectureCode(address.getPrefectureCode())
        .address1(address.getAddress1())
        .address2(address.getAddress2())
        .address3(address.getAddress3())
        .streetAddress(address.getStreetAddress())
        .buildingName(address.getBuildingName())
        .supplement(address.getSupplement())
        .build();
    var hours = request.getHours();
    var hoursObject = LocationRegisterServiceInput.HoursObject.builder()
//        .openingTime(LocalTime.parse(hours.getOpeningTime(), DateTimeFormatter.ofPattern("HH:mm")))
//        .closingTime(LocalTime.parse(hours.getClosingTime(), DateTimeFormatter.ofPattern("HH:mm")))
        .supplement(hours.getSupplement())
        .build();
    return LocationRegisterServiceInput.builder()
        .name(request.getName())
        .contact(contactObject)
        .address(addressObject)
        .openDate(request.getOpenDate())
        .closeDate(request.getCloseDate())
        .hours(hoursObject)
        .memo(request.getMemo())
        .build();
  }

}
