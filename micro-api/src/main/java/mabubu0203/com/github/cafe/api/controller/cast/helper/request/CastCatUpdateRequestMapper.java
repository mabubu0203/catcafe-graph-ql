package mabubu0203.com.github.cafe.api.controller.cast.helper.request;

import com.netflix.dgs.codegen.types.CastCatCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatModifyServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.WriteRequestMapper;

@RequiredArgsConstructor
public class CastCatUpdateRequestMapper implements
    WriteRequestMapper<CastCatCommand, CastCatModifyServiceInput> {

  private final String castCatCode;
  private final Integer version;

  @Override
  public CastCatModifyServiceInput apply(CastCatCommand request) {
    return CastCatModifyServiceInput.builder()
        .castCatCode(this.castCatCode)
        .name(request.getName())
        .image(request.getImage())
        .type(request.getType())
        .sex(request.getSex().name())
        .birthdayDate(request.getBirthdayDate())
        .favorite(request.getFavorite())
        .dislike(request.getDislike())
        .prohibition(request.getProhibition())
        .brothers(request.getBrothers())
        .sisters(request.getSisters())
        .memo(request.getMemo())
        .version(this.version)
        .build();
  }

}
