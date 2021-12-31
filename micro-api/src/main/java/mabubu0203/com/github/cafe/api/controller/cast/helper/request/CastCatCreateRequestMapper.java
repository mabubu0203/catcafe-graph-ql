package mabubu0203.com.github.cafe.api.controller.cast.helper.request;

import com.netflix.dgs.codegen.types.CastCatCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatRegisterServiceInput;
import mabubu0203.com.github.cafe.common.controller.helper.request.CreateRequestMapper;


@RequiredArgsConstructor
public class CastCatCreateRequestMapper implements
    CreateRequestMapper<CastCatCommand, CastCatRegisterServiceInput> {

  @Override
  public CastCatRegisterServiceInput apply(CastCatCommand request) {
    return CastCatRegisterServiceInput.builder()
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
        .build();
  }

}
