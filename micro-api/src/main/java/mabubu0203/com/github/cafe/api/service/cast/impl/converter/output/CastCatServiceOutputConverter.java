package mabubu0203.com.github.cafe.api.service.cast.impl.converter.output;

import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatServiceOutput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceOutputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;

public class CastCatServiceOutputConverter
    implements ServiceOutputConverter<CastCatEntity, CastCatServiceOutput> {

  @Override
  public CastCatServiceOutput apply(CastCatEntity castCat) {
    return CastCatServiceOutput.builder()
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
