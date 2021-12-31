package mabubu0203.com.github.cafe.domain.value.code;

import java.util.Optional;
import java.util.UUID;

public record CastCode(UUID value) {

  public static CastCode emptyCode() {
    return new CastCode(null);
  }

  public boolean isEmpty() {
    return Optional.ofNullable(value)
        .map(UUID::toString)
        .map(String::isEmpty)
        .orElse(true);
  }

  public String getValue() {
    return Optional.ofNullable(value)
        .map(UUID::toString)
        .orElse(null);
  }

}
