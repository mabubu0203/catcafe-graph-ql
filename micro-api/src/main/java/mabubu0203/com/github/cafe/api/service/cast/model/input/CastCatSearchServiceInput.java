package mabubu0203.com.github.cafe.api.service.cast.model.input;

import java.util.List;
import java.util.Optional;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

@Accessors(fluent = true)
@Builder
@Value
public class CastCatSearchServiceInput implements ServiceInput {

  Optional<List<String>> optCastCatCodes;
  Optional<Integer> optPage;
  Optional<Integer> optSize;
  Optional<List<String>> optSortKeys;

}
