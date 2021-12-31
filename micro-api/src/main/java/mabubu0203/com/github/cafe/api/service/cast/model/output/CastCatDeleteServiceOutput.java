package mabubu0203.com.github.cafe.api.service.cast.model.output;

import lombok.Builder;
import lombok.Getter;
import mabubu0203.com.github.cafe.common.service.model.ServiceOutput;

@Builder
@Getter
public class CastCatDeleteServiceOutput implements ServiceOutput {

  private final Integer id;

}
