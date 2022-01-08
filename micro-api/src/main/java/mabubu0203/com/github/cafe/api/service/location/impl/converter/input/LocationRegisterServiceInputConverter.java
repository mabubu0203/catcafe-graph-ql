package mabubu0203.com.github.cafe.api.service.location.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.location.model.input.LocationRegisterServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.location.LocationEntity;
import mabubu0203.com.github.cafe.domain.value.MailAddress;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.PhoneNumber;
import mabubu0203.com.github.cafe.domain.value.PostalCode;
import mabubu0203.com.github.cafe.domain.value.Prefecture;
import mabubu0203.com.github.cafe.domain.value.Supplement;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;

public class LocationRegisterServiceInputConverter
    implements ServiceInputConverter<LocationRegisterServiceInput, LocationEntity> {

  @Override
  public LocationEntity apply(LocationRegisterServiceInput input) {
    var contactObject = input.contact();
    var addressObject = input.address();
    var hoursObject = input.hours();
    var locationCode = LocationCode.newCode();
    var phoneNumber = new PhoneNumber(contactObject.phoneNumber());
    var mailAddress = new MailAddress(contactObject.mailAddress());
    var postalCode = new PostalCode(addressObject.postalCode());
    var prefecture = Prefecture.getByCode(addressObject.prefectureCode());
    var addressSupplement = new Supplement(addressObject.supplement());
    var hoursSupplement = new Supplement(hoursObject.supplement());
    var memo = new Memo(input.memo());
    var version = Version.empty();
    return LocationEntity.builder()
        .locationCode(locationCode)
        .name(input.name())
        .phoneNumber(phoneNumber)
        .mailAddress(mailAddress)
        .postalCode(postalCode)
        .prefecture(prefecture)
        .address1(addressObject.address1())
        .address2(addressObject.address2())
        .address3(addressObject.address3())
        .streetAddress(addressObject.streetAddress())
        .buildingName(addressObject.buildingName())
        .addressSupplement(addressSupplement)
        .openDate(input.openDate())
        .closeDate(input.closeDate())
        .openingTime(hoursObject.openingTime())
        .closingTime(hoursObject.closingTime())
        .hoursSupplement(hoursSupplement)
        .memo(memo)
        .version(version)
        .build();
  }

}
