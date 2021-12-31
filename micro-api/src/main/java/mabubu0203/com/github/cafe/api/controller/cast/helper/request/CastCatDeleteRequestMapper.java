package mabubu0203.com.github.cafe.api.controller.cast.helper.request;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatDeleteServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.DeleteRequestMapper;

@RequiredArgsConstructor
public class CastCatDeleteRequestMapper implements DeleteRequestMapper<CastCatDeleteServiceInput> {

  private final Integer version;

  @Override
  public CastCatDeleteServiceInput apply(String castCatCode) {
    return CastCatDeleteServiceInput.builder()
        .castCatCode(castCatCode)
        .version(this.version)
        .build();
  }

}
