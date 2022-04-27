package mabubu0203.com.github.cafe.domain.value.authorization;

import java.util.List;
import java.util.Optional;

/**
 * ロール
 */
public record Role(String key, List<Permission> permissions) {

  public boolean isEmpty() {
    return Optional.ofNullable(key)
        .map(String::isEmpty)
        .orElse(true);
  }

  public boolean hasPermission() {
    return !permissions.isEmpty();
  }

}
