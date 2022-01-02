package mabubu0203.com.github.cafe.api.controller.cast.helper.request;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatSearchServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.ReadRequestMapper;

@RequiredArgsConstructor
public class CastCatSearchRequestMapper implements ReadRequestMapper<CastCatSearchServiceInput> {

  private final List<String> castCatCodes;

  @Override
  public CastCatSearchServiceInput get() {
    return
        CastCatSearchServiceInput.builder()
            .castCatCodes(Optional.ofNullable(this.castCatCodes).orElse(Collections.emptyList()))
            .build();
  }

}
