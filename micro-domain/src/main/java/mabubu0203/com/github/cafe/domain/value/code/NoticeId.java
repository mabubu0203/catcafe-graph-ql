package mabubu0203.com.github.cafe.domain.value.code;

import java.util.Optional;

/**
 * お知らせID
 */
public record NoticeId(Integer value) {

  public static NoticeId emptyId() {
    return new NoticeId(null);
  }

  public boolean isEmpty() {
    return Optional.ofNullable(value).isEmpty();
  }

}
