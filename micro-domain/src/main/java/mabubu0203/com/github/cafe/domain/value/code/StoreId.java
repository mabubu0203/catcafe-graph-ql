package mabubu0203.com.github.cafe.domain.value.code;

import java.util.Optional;

/**
 * 店舗ID
 */
public record StoreId(Integer value) {

  public static StoreId emptyId() {
    return new StoreId(null);
  }

  public boolean isEmpty() {
    return Optional.ofNullable(value).isEmpty();
  }

}
