package mabubu0203.com.github.cafe.api.model;

import lombok.Builder;
import lombok.Getter;

/**
 * キャスト
 */
@Builder
@Getter
public class Cast {

  private final Integer id;
  private final String firstAttendanceDate;
  private final String lastAttendanceDate;
  private final String memo;

}
