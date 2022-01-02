package mabubu0203.com.github.cafe.api.controller.cast.helper.request;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatSearchServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.ReadRequestMapper;

@RequiredArgsConstructor
public class CastCatFindRequestMapper implements ReadRequestMapper<CastCatSearchServiceInput> {

  private final String castCatCode;

  @Override
  public CastCatSearchServiceInput get() {
    var castCatCodes = new ArrayList<String>();
    castCatCodes.add(this.castCatCode);
    return CastCatSearchServiceInput.builder()
        .castCatCodes(castCatCodes)
        .build();
  }

}
