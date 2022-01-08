package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatModifyServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.value.HttpUrl;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.cast.CatSex;
import mabubu0203.com.github.cafe.domain.value.code.CastCatCode;

public class CastCatModifyServiceInputConverter
    implements ServiceInputConverter<CastCatModifyServiceInput, CastCatEntity> {

  @Override
  public CastCatEntity apply(CastCatModifyServiceInput input) {
    var castCatCode = new CastCatCode(input.castCatCode());
    var sex = CatSex.getByLabel(input.sex());
    var image = new HttpUrl(input.image());
    var memo = new Memo(input.memo());
    var version = new Version(input.version());
    return CastCatEntity.builder()
        .castCatCode(castCatCode)
        .name(input.name())
        .image(image)
        .type(input.type())
        .sex(sex)
        .birthdayDate(input.birthdayDate())
        .favorite(input.favorite())
        .dislike(input.dislike())
        .prohibition(input.prohibition())
        // TODO
//        .brothers()
//        .sisters()
        .memo(memo)
        .version(version)
        .build();
  }
}
