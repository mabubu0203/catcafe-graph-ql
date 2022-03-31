package mabubu0203.com.github.cafe.domain.value.authorization;

import java.util.Optional;

/**
 * メモ
 */
public record Username(String value) {

  public boolean isEmpty() {
    return Optional.ofNullable(value)
        .map(String::isEmpty)
        .orElse(true);
  }

}
