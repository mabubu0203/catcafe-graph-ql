package mabubu0203.com.github.cafe.domain.value;

import java.util.Optional;

/**
 * 店舗住所(郵便番号)
 */
public record PostalCode(String value) {

  public boolean isEmpty() {
    return Optional.ofNullable(value)
        .map(String::isEmpty)
        .orElse(true);
  }

}
