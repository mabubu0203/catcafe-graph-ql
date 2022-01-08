package mabubu0203.com.github.cafe.api.service.cast.impl.converter.input;

import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatDeleteServiceInput;
import mabubu0203.com.github.cafe.common.service.converter.ServiceInputConverter;
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.code.CastCatCode;

public class CastCatDeleteServiceInputConverter
    implements ServiceInputConverter<CastCatDeleteServiceInput, CastCatEntity> {

  @Override
  public CastCatEntity apply(CastCatDeleteServiceInput input) {
    var castCatCode = new CastCatCode(input.castCatCode());
    var version = new Version(input.version());
    return CastCatEntity.builder()
        .castCatCode(castCatCode)
        .version(version)
        .build();
  }

}
