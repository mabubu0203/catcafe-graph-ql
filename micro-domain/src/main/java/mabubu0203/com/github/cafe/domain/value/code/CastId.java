package mabubu0203.com.github.cafe.domain.value.code;

import java.util.Optional;

/**
 * キャストID
 */
public record CastId(Integer value) {

  public static CastId emptyId() {
    return new CastId(null);
  }

  public boolean isEmpty() {
    return Optional.ofNullable(value).isEmpty();
  }

}
