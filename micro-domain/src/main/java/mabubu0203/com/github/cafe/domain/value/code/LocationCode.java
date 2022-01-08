package mabubu0203.com.github.cafe.domain.value.code;

import java.util.Optional;
import java.util.UUID;

public record LocationCode(String value) {

  public static LocationCode newCode() {
    return new LocationCode(UUID.randomUUID().toString());
  }

  public boolean isEmpty() {
    return Optional.ofNullable(value)
        .map(String::isEmpty)
        .orElse(true);
  }

}
