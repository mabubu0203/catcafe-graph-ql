package mabubu0203.com.github.cafe.domain.value;

import java.util.Objects;

/**
 * バージョン
 */
public record Version(Integer value) {

  public static Version empty() {
    return new Version(null);
  }

  public boolean isEmpty() {
    return Objects.isNull(value);
  }

}
