package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatModifyServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.ModifyServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;

public class CastCatModifyServiceOutputConverter implements
    ModifyServiceOutputConverter<CastCatEntity, CastCatModifyServiceOutput> {

  @Override
  public CastCatModifyServiceOutput apply(CastCatEntity castCat) {
    return CastCatModifyServiceOutput.builder()
        .code(castCat.getCastCatCodeValue())
        .name(null)
        .image(null)
        .type(null)
        .sex(null)
        .birthdayDate(null)
        .favorite(null)
        .dislike(null)
        .prohibition(null)
        .brothers(null)
        .sisters(null)
        .memo(null)
        .version(null)
        .build();
  }

}
