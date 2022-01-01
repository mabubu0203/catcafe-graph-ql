package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatRegisterServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.RegisterServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;

public class CastCatRegisterServiceOutputConverter implements
    RegisterServiceOutputConverter<CastCatEntity, CastCatRegisterServiceOutput> {

  @Override
  public CastCatRegisterServiceOutput apply(CastCatEntity castCat) {
    return CastCatRegisterServiceOutput.builder()
        .code(castCat.getCastCatCodeValue())
        .name(castCat.name())
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
