package mabubu0203.com.github.cafe.api.controller.cast;

import com.netflix.dgs.codegen.types.Cast;
import com.netflix.dgs.codegen.types.CastCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.controller.cast.helper.request.CastCreateRequestMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.request.CastDeleteRequestMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.request.CastUpdateRequestMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.response.CastDeleteResponseMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.response.CastResponseMapper;
import mabubu0203.com.github.cafe.api.service.cast.CastDeleteService;
import mabubu0203.com.github.cafe.api.service.cast.CastModifyService;
import mabubu0203.com.github.cafe.api.service.cast.CastRegisterService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CastCommandController {

  private final CastRegisterService castResisterService;
  private final CastModifyService castModifyService;
  private final CastDeleteService castDeleteService;

  @MutationMapping(name = "castCreate")
  public Mono<Cast> castCreate(
      @Argument("input") CastCommand input
  ) {
    return Mono.just(input)
        .map(new CastCreateRequestMapper())
        .flatMap(this.castResisterService::action)
        .map(new CastResponseMapper());
  }

  @MutationMapping(name = "castUpdate")
  public Mono<Cast> castUpdate(
      @Argument("code") String code,
      @Argument("input") CastCommand input,
      @Argument("version") Integer version
  ) {
    return Mono.just(input)
        .map(new CastUpdateRequestMapper(code, version))
        .flatMap(this.castModifyService::action)
        .map(new CastResponseMapper());
  }

  @MutationMapping(name = "castDelete")
  public Mono<String> castDelete(
      @Argument("code") String code,
      @Argument("version") Integer version
  ) {
    return Mono.just(code)
        .map(new CastDeleteRequestMapper(version))
        .flatMap(this.castDeleteService::action)
        .map(new CastDeleteResponseMapper());
  }

}
