package mabubu0203.com.github.cafe.domain.value.code;

import java.util.Optional;
import java.util.UUID;

public record CastCatCode(String value) {

  public static CastCatCode newCode() {
    return new CastCatCode(UUID.randomUUID().toString());
  }

  public boolean isEmpty() {
    return Optional.ofNullable(value)
        .map(String::isEmpty)
        .orElse(true);
  }

}
