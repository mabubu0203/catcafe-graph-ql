package mabubu0203.com.github.cafe.domain.value.code;

import java.util.Optional;
import java.util.UUID;

public record CastCode(String value) {

  public static CastCode newCode() {
    return new CastCode(UUID.randomUUID().toString());
  }

  public boolean isEmpty() {
    return Optional.ofNullable(value)
        .map(String::isEmpty)
        .orElse(true);
  }

}
