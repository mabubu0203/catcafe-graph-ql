package mabubu0203.com.github.cafe.api.service.cast.model.input;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;
import java.time.LocalDate;

@Accessors(fluent = true)
@Builder
@Value
public class CastRegisterServiceInput implements ServiceInput {

  String castCatCode;
  String locationCode;
  String employmentStatus;
  LocalDate firstAttendanceDate;
  LocalDate lastAttendanceDate;
  String memo;

}
