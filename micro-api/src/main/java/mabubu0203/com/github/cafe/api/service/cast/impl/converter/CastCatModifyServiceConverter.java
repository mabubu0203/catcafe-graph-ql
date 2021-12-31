package mabubu0203.com.github.cafe.api.service.cast.impl.converter;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatModifyServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatModifyServiceOutput;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.value.HttpUrl;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.cast.CatSex;
import mabubu0203.com.github.cafe.domain.value.code.CastCatId;

public class CastCatModifyServiceConverter {

  public CastCatEntity fromInput(CastCatModifyServiceInput input) {
    var castCatId = new CastCatId(input.getCastCatId());
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
        .createdDateTime(null)
        .version(input.getVersion())
        .updatedDateTime(null)
        .build();
  }

  public CastCatModifyServiceOutput toOutput(CastCatId castCatId) {
    return CastCatModifyServiceOutput.builder()
        .id(castCatId.value()).build();
  }

}
