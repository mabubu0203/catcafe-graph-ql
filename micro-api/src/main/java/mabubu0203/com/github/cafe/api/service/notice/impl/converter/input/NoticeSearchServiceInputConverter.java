package mabubu0203.com.github.cafe.api.service.notice.impl.converter.input;

import java.util.Optional;
import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeSearchServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.notice.NoticeSearchConditions;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import mabubu0203.com.github.cafe.domain.value.code.NoticeCode;

public class NoticeSearchServiceInputConverter
    implements ServiceInputConverter<NoticeSearchServiceInput, NoticeSearchConditions> {

  @Override
  public NoticeSearchConditions apply(NoticeSearchServiceInput input) {
    var noticeCodes = input.noticeCodes()
        .stream()
        .map(NoticeCode::new)
        .toList();
    var locationCodes = input.locationCodes()
        .stream()
        .map(LocationCode::new)
        .toList();
    return new NoticeSearchConditions(
        Optional.ofNullable(noticeCodes),
        Optional.ofNullable(locationCodes));
  }

}
