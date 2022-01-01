package mabubu0203.com.github.cafe.api.service.cast.model.output;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.service.model.ServiceOutput;

@Accessors(fluent = true)
@Builder
@Value
public class CastCatModifyServiceOutput implements ServiceOutput {

  String code;
  String name;
  String image;
  String type;
  String sex;
  LocalDate birthdayDate;
  String favorite;
  String dislike;
  String prohibition;
  List<String> brothers;
  List<String> sisters;
  String memo;
  Integer version;

}
