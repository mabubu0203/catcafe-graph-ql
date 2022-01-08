package mabubu0203.com.github.cafe.api.controller.cast.helper.request;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastSearchServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.ReadRequestMapper;
import java.util.List;

@RequiredArgsConstructor
public class CastSearchRequestMapper
    implements ReadRequestMapper<CastSearchServiceInput> {

  private final List<String> castCodes;
  private final List<String> locationCodes;

  @Override
  public CastSearchServiceInput get() {
    return CastSearchServiceInput.builder()
        .castCodes(this.castCodes)
        .locationCodes(this.locationCodes)
        .build();
  }
}
