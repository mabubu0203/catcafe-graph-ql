package mabubu0203.com.github.cafe.api.service.cast.model.input;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

@Accessors(fluent = true)
@Builder
@Value
public class CastModifyServiceInput implements ServiceInput {

  String castCode;
  String locationCode;
  String castCatCode;
  String employmentStatus;
  LocalDate firstAttendanceDate;
  LocalDate lastAttendanceDate;
  String memo;
  Integer version;

}
