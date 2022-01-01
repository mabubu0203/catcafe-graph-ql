package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatRegisterServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.ServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;

public class CastCatRegisterServiceOutputConverter implements
    ServiceOutputConverter<CastCatEntity, CastCatRegisterServiceOutput> {

  @Override
  public CastCatRegisterServiceOutput apply(CastCatEntity castCat) {
    return CastCatRegisterServiceOutput.builder()
        .castCatCode(castCat.getCastCatCodeValue())
        .name(castCat.name())
        .image(castCat.getImageValue())
        .type(castCat.type())
        .sex(castCat.getSexLabel())
        .birthdayDate(castCat.birthdayDate())
        .favorite(castCat.favorite())
        .dislike(castCat.dislike())
        .prohibition(castCat.prohibition())
        .memo(castCat.getMemoValue())
        .version(castCat.version())
        .build();
  }
}
