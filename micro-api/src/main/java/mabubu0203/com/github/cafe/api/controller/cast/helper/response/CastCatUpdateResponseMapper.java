package mabubu0203.com.github.cafe.api.controller.cast.helper.response;

import com.netflix.dgs.codegen.types.CastCat;
import com.netflix.dgs.codegen.types.CatSex;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatModifyServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.UpdateResponseMapper;

public class CastCatUpdateResponseMapper implements
    UpdateResponseMapper<CastCatModifyServiceOutput, CastCat> {

  @Override
  public CastCat apply(CastCatModifyServiceOutput output) {
    var sex = CatSex.valueOf(output.sex());
    return new CastCat.Builder()
        .code(output.code())
        .name(output.name())
        .image(output.image())
        .type(output.type())
        .sex(sex)
        .birthdayDate(output.birthdayDate())
        .favorite(output.favorite())
        .dislike(output.dislike())
        .prohibition(output.prohibition())
        .brothers(null)
        .sisters(null)
        .memo(output.memo())
        .version(output.version())
        .build();
  }
}
