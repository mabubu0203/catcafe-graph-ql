package mabubu0203.com.github.cafe.api.controller.cast;

import com.netflix.dgs.codegen.types.Cast;
import com.netflix.dgs.codegen.types.CastCat;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.controller.cast.helper.request.CastCatFindRequestMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.request.CastCatSearchRequestMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.response.CastCatResponseMapper;
import mabubu0203.com.github.cafe.api.service.cast.CastCatSearchService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CastCatQueryController {

  private final CastCatSearchService castCatSearchService;

  @SchemaMapping
  public Mono<CastCat> castCat(Cast cast) {
    return Optional.of(cast)
        .map(Cast::getCastCat)
        .map(CastCat.class::cast)
        .map(CastCat::getCode)
        .map(code -> new CastCatFindRequestMapper(code).get())
        .map(this.castCatSearchService::action)
        .orElse(Flux.empty())
        .last()
        .map(new CastCatResponseMapper());
  }

  @QueryMapping(name = "castCatSearch")
  public Flux<CastCat> castCatSearch(
      @Argument("codes") List<String> codes
  ) {
    return Optional.of(new CastCatSearchRequestMapper(codes).get())
        .map(this.castCatSearchService::action)
        .orElse(Flux.empty())
        .map(new CastCatResponseMapper());
  }

}
