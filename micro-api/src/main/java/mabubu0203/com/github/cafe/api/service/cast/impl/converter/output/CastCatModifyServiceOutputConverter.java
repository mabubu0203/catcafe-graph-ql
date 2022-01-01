package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatModifyServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.output.ServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;

public class CastCatModifyServiceOutputConverter implements
    ServiceOutputConverter<CastCatEntity, CastCatModifyServiceOutput> {

  @Override
  public CastCatModifyServiceOutput apply(CastCatEntity castCat) {
    return CastCatModifyServiceOutput.builder()
        .code(castCat.getCastCatCodeValue())
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
