package mabubu0203.com.github.cafe.api.service.cast.impl.converter;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatDeleteServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatDeleteServiceOutput;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.value.code.CastCatId;

public class CastCatDeleteServiceConverter {

  public CastCatEntity fromInput(CastCatDeleteServiceInput input) {
    var castCatId = new CastCatId(input.getCastCatId());
    return CastCatEntity.builder()
        .castCatId(castCatId)
        .version(input.getVersion())
        .build();
  }

  public CastCatDeleteServiceOutput toOutput(CastCatId castCatId) {
    return CastCatDeleteServiceOutput.builder()
        .id(castCatId.value())
        .build();
  }

}
