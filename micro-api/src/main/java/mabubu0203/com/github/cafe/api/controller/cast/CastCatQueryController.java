package mabubu0203.com.github.cafe.api.controller.cast;

import com.netflix.dgs.codegen.types.CastCat;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.controller.cast.helper.request.CastCatFindRequestMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.response.CastCatFindResponseMapper;
import mabubu0203.com.github.cafe.api.service.cast.CastCatSearchService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CastCatQueryController {

  private final CastCatSearchService castCatSearchService;

  @QueryMapping
  public Mono<CastCat> castCatFind(
      @Argument("code") String code
  ) {
    return Mono.just(code)
        .map(new CastCatFindRequestMapper())
        .map(this.castCatSearchService::action)
        .mapNotNull(Flux::blockFirst)
        .map(new CastCatFindResponseMapper());
  }

  @QueryMapping
  public Flux<CastCat> castCatSearch() {
    return Flux.just(
        CastCat.newBuilder()
            .code("")
            .build());
  }

}
