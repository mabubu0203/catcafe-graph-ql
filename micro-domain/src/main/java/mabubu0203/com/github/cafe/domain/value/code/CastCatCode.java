package mabubu0203.com.github.cafe.domain.value.code;

import java.util.Optional;
import java.util.UUID;

public record CastCatCode(UUID value) {

  public static CastCatCode emptyCode() {
    return new CastCatCode(null);
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
