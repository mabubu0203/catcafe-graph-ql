package mabubu0203.com.github.cafe.api.controller.cast.helper.request;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastDeleteServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.WriteRequestMapper;

@RequiredArgsConstructor
public class CastDeleteRequestMapper implements
    WriteRequestMapper<String, CastDeleteServiceInput> {

  private final Integer version;

  @Override
  public CastDeleteServiceInput apply(String castCode) {
    return CastDeleteServiceInput.builder()
        .castCode(castCode)
        .version(this.version)
        .build();
  }
}
