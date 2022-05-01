package mabubu0203.com.github.cafe.domain.value.code;

import java.util.Optional;
import java.util.UUID;

public record UserCode(String value) {

  public static UserCode newCode() {
    return new UserCode(UUID.randomUUID().toString());
  }

  public boolean isEmpty() {
    return Optional.ofNullable(value)
        .map(String::isEmpty)
        .orElse(true);
  }

}
