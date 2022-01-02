package mabubu0203.com.github.cafe.domain.entity.cast;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.entity.SearchConditions;
import mabubu0203.com.github.cafe.domain.value.code.CastCatCode;

@Accessors(fluent = true)
@Value
@EqualsAndHashCode(callSuper = true)
public class CastCatSearchConditions extends SearchConditions {

  Optional<List<CastCatCode>> optCastCatCodes;

  public List<String> castCatCodes() {
    return this.optCastCatCodes.orElseGet(Collections::emptyList)
        .stream()
        .map(CastCatCode::value)
        .toList();
  }

}
