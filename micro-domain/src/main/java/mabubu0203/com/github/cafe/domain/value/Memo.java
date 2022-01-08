package mabubu0203.com.github.cafe.domain.value;

import java.util.Optional;

/**
 * メモ
 */
public record Memo(String value) {

  public boolean isEmpty() {
    return Optional.ofNullable(value)
        .map(String::isEmpty)
        .orElse(true);
  }

}
