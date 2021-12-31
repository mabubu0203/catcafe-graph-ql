package mabubu0203.com.github.cafe.domain.value.code;

import java.util.Optional;
import java.util.UUID;

public record NoticeCode(String value) {

  public static NoticeCode newCode() {
    return new NoticeCode(UUID.randomUUID().toString());
  }

  public boolean isEmpty() {
    return Optional.ofNullable(value)
        .map(String::isEmpty)
        .orElse(true);
  }

}
