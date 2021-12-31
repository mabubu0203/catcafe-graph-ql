package mabubu0203.com.github.cafe.api.service.cast.model.input;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Value;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

@Builder
@Value
public class CastCatRegisterServiceInput implements ServiceInput {

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

}
