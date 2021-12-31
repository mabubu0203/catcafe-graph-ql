package mabubu0203.com.github.cafe.domain.value;

import java.util.Optional;
import mabubu0203.com.github.cafe.domain.check.CheckPhoneNumber;

/**
 * 電話番号
 */
public record PhoneNumber(@CheckPhoneNumber String value) {

  public boolean isEmpty() {
    return Optional.ofNullable(value)
        .map(String::isEmpty)
        .orElse(true);
  }

}
