package mabubu0203.com.github.cafe.api.controller.cast;

import com.netflix.dgs.codegen.types.CastCat;
import com.netflix.dgs.codegen.types.CastCatCommand;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.controller.cast.helper.request.CastCatCreateRequestMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.request.CastCatDeleteRequestMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.request.CastCatUpdateRequestMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.response.CastCatDeleteResponseMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.response.CastCatResponseMapper;
import mabubu0203.com.github.cafe.api.service.cast.CastCatDeleteService;
import mabubu0203.com.github.cafe.api.service.cast.CastCatModifyService;
import mabubu0203.com.github.cafe.api.service.cast.CastCatRegisterService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CastCatCommandController {

  private final CastCatRegisterService castCatRegisterService;
  private final CastCatModifyService castCatModifyService;
  private final CastCatDeleteService castCatDeleteService;

  @MutationMapping(name = "castCatCreate")
  public Mono<CastCat> castCatCreate(
      @Argument("input") @Valid CastCatCommand input
  ) {
    return Mono.just(input)
        .map(new CastCatCreateRequestMapper())
        .flatMap(this.castCatRegisterService::action)
        .map(new CastCatResponseMapper());
  }

  @MutationMapping(name = "castCatUpdate")
  public Mono<CastCat> castCatUpdate(
      @Argument("code") String code,
      @Argument("input") @Valid CastCatCommand input,
      @Argument("version") Integer version
  ) {
    return Mono.just(input)
        .map(new CastCatUpdateRequestMapper(code, version))
        .flatMap(this.castCatModifyService::action)
        .map(new CastCatResponseMapper());
  }

  @MutationMapping(name = "castCatDelete")
  public Mono<String> castCatDelete(
      @Argument("code") String code,
      @Argument("version") Integer version
  ) {
    return Mono.just(code)
        .map(new CastCatDeleteRequestMapper(version))
        .flatMap(this.castCatDeleteService::action)
        .map(new CastCatDeleteResponseMapper());
  }

}
