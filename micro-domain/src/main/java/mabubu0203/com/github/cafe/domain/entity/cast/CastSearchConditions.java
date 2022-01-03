package mabubu0203.com.github.cafe.domain.entity.cast;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.entity.SearchConditions;
import mabubu0203.com.github.cafe.domain.value.code.CastCode;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;

@Accessors(fluent = true)
@Value
@EqualsAndHashCode(callSuper = true)
public class CastSearchConditions extends SearchConditions {

  Optional<List<CastCode>> optCastCodes;
  Optional<List<LocationCode>> optLocationCodes;

  public List<String> castCodes() {
    return this.optCastCodes.orElseGet(Collections::emptyList)
        .stream()
        .map(CastCode::value)
        .toList();
  }

  public List<String> locationCodes() {
    return this.optLocationCodes.orElseGet(Collections::emptyList)
        .stream()
        .map(LocationCode::value)
        .toList();
  }

}
