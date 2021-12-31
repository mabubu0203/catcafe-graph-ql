package mabubu0203.com.github.cafe.api.controller.cast;

import com.netflix.dgs.codegen.types.CastCat;
import com.netflix.dgs.codegen.types.CastCatCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.controller.cast.helper.request.CastCatCreateRequestMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.request.CastCatUpdateRequestMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.response.CastCatCreateResponseMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.response.CastCatUpdateResponseMapper;
import mabubu0203.com.github.cafe.api.service.cast.CastCatDeleteService;
import mabubu0203.com.github.cafe.api.service.cast.CastCatModifyService;
import mabubu0203.com.github.cafe.api.service.cast.CastCatResisterService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CastCatCommandController {

  private final CastCatResisterService castCatResisterService;
  private final CastCatModifyService castCatModifyService;
  private final CastCatDeleteService castCatDeleteService;

  @MutationMapping
  public Mono<CastCat> castCatCreate(
      @Argument("input") CastCatCommand input
  ) {
    return Mono.just(input)
        .map(new CastCatCreateRequestMapper("cats"))
        .flatMap(this.castCatResisterService::action)
        .map(new CastCatCreateResponseMapper());
  }

  @MutationMapping
  public Mono<CastCat> castCatUpdate(
      @Argument("id") Integer id,
      @Argument("input") CastCatCommand input,
      @Argument("version") Integer version
  ) {
    return Mono.just(input)
        .map(new CastCatUpdateRequestMapper("cats", id, version))
        .flatMap(this.castCatModifyService::action)
        .map(new CastCatUpdateResponseMapper());
  }

  @MutationMapping
  public Integer castCatDelete(
      @Argument("id") Integer id,
      @Argument("version") Integer version
  ) {
    return 2;
  }

}
