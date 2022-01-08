package mabubu0203.com.github.cafe.api.service.cast.model.input;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

@Accessors(fluent = true)
@Builder
@Value
public class CastCatModifyServiceInput implements ServiceInput {

  String castCatCode;
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
