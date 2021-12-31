package mabubu0203.com.github.cafe.api.service.cast.model.input;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

@Builder
@Getter
public class CastCatModifyServiceInput implements ServiceInput {

  private final String cats;
  private final Integer castCatId;
  private final String name;
  private final String image;
  private final String type;
  private final String sex;
  private final LocalDate birthdayDate;
  private final String favorite;
  private final String dislike;
  private final String prohibition;
  private final List<Integer> brothers;
  private final List<Integer> sisters;
  private final String memo;
  private final Integer version;

}
