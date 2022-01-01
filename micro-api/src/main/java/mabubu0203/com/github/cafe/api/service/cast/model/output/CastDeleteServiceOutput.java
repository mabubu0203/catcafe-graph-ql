package mabubu0203.com.github.cafe.api.service.cast.model.output;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.service.model.ServiceOutput;

@Accessors(fluent = true)
@Builder
@Value
public class CastDeleteServiceOutput implements ServiceOutput {

  String code;

}
