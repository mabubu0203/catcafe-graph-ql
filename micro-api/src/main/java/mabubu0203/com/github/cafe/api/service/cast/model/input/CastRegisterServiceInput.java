package mabubu0203.com.github.cafe.api.service.cast.model.input;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

@Builder
@Getter
public class CastRegisterServiceInput implements ServiceInput {

  private final String cats;
  private final Integer castCatId;
  private final Integer storeId;
  private final String employmentStatus;
  private final LocalDate firstAttendanceDate;
  private final LocalDate lastAttendanceDate;
  private final String memo;

}
