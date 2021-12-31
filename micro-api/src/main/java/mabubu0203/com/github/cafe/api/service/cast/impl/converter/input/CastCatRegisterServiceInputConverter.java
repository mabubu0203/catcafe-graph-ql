package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatRegisterServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.input.RegisterServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.value.HttpUrl;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.cast.CatSex;
import mabubu0203.com.github.cafe.domain.value.code.CastCatId;

public class CastCatRegisterServiceInputConverter implements
    RegisterServiceInputConverter<CastCatRegisterServiceInput, CastCatEntity> {

  @Override
  public CastCatEntity apply(CastCatRegisterServiceInput input) {
    var castCatId = CastCatId.emptyId();
    var sex = CatSex.getByLabel(input.getSex());
    var image = new HttpUrl(input.getImage());
    var memo = new Memo(input.getMemo());
    return CastCatEntity.builder()
        .castCatId(castCatId)
        .name(input.getName())
        .image(image)
        .type(input.getType())
        .sex(sex)
        .birthdayDate(input.getBirthdayDate())
        .favorite(input.getFavorite())
        .dislike(input.getDislike())
        .prohibition(input.getProhibition())
        // TODO
//        .brothers()
//        .sisters()
        .memo(memo)
        .version(null)
        .build();
  }
}
