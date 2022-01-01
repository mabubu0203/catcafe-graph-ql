package mabubu0203.com.github.cafe.api.controller.cast.helper.request;

import java.util.ArrayList;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatSearchServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.FindRequestMapper;

@RequiredArgsConstructor
public class CastCatFindRequestMapper implements FindRequestMapper<CastCatSearchServiceInput> {

  @Override
  public CastCatSearchServiceInput apply(String castCatCode) {
    var castCatCodes = new ArrayList<String>();
    castCatCodes.add(castCatCode);
    return CastCatSearchServiceInput.builder()
        .optCastCatCodes(Optional.of(castCatCodes))
        .optPage(Optional.empty())
        .optSize(Optional.empty())
        .optSortKeys(Optional.empty())
        .build();
  }

}
