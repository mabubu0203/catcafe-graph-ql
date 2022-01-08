package mabubu0203.com.github.cafe.api.service.location.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.location.model.output.LocationServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.entity.location.LocationEntity;

public class LocationServiceOutputConverter
    implements ServiceOutputConverter<LocationEntity, LocationServiceOutput> {

  @Override
  public LocationServiceOutput apply(LocationEntity locationEntity) {
    return LocationServiceOutput.builder()
        .locationCode(locationEntity.getLocationCodeValue())
        .name(locationEntity.name())
        .contact(
            LocationServiceOutput.ContactObject.builder()
                .phoneNumber(locationEntity.getPhoneNumberValue())
                .mailAddress(locationEntity.getMailAddressValue())
                .build()
        )
        .address(
            LocationServiceOutput.AddressObject.builder()
                .postalCode(locationEntity.getPostalCodeValue())
                .prefectureCode(locationEntity.getPrefectureCode())
                .prefectureLabel(locationEntity.getPrefectureLabel())
                .address1(locationEntity.address1())
                .address2(locationEntity.address2())
                .address3(locationEntity.address3())
                .streetAddress(locationEntity.streetAddress())
                .buildingName(locationEntity.buildingName())
                .supplement(locationEntity.getAddressSupplementValue())
                .build())
        .openDate(locationEntity.openDate())
        .closeDate(locationEntity.closeDate())
        .hours(
            LocationServiceOutput.HoursObject.builder()
                .openingTime(locationEntity.openingTime())
                .closingTime(locationEntity.closingTime())
                .supplement(locationEntity.getHoursSupplementValue())
                .build())
        .memo(locationEntity.getMemoValue())
        .version(locationEntity.getVersionValue())
        .build();
  }

}
