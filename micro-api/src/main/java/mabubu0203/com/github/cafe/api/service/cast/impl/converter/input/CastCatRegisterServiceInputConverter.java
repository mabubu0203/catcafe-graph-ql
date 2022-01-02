package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatRegisterServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.value.HttpUrl;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.cast.CatSex;
import mabubu0203.com.github.cafe.domain.value.code.CastCatCode;

public class CastCatRegisterServiceInputConverter implements
    ServiceInputConverter<CastCatRegisterServiceInput, CastCatEntity> {

  @Override
  public CastCatEntity apply(CastCatRegisterServiceInput input) {
    var castCatCode = CastCatCode.newCode();
    var sex = CatSex.getByLabel(input.sex());
    var image = new HttpUrl(input.image());
    var memo = new Memo(input.memo());
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
        .version(null)
        .build();
  }
}
