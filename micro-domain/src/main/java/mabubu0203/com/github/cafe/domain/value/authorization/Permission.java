package mabubu0203.com.github.cafe.domain.value.authorization;

import java.util.Optional;

/**
 * Permission
 */
public record Permission(String key) {

  public boolean isEmpty() {
    return Optional.ofNullable(key)
        .map(String::isEmpty)
        .orElse(true);
  }

}
