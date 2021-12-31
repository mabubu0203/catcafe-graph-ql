package mabubu0203.com.github.cafe.api.service.cast.model.input;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

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
