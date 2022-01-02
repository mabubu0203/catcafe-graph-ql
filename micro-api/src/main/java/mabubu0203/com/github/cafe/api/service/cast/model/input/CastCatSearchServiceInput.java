package mabubu0203.com.github.cafe.api.service.cast.model.input;

import java.util.List;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

@Accessors(fluent = true)
@Builder
@Value
public class CastCatSearchServiceInput implements ServiceInput {

  List<String> castCatCodes;

}
