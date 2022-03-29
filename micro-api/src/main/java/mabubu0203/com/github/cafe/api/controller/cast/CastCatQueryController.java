package mabubu0203.com.github.cafe.api.controller.cast;

import com.netflix.dgs.codegen.types.Cast;
import com.netflix.dgs.codegen.types.CastCat;
import java.util.List;
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

  @SchemaMapping(field = "castCat", typeName = "Cast")
  public Mono<CastCat> castCat(Cast cast) {
    return Mono.just(cast)
        .map(Cast::getCastCat)
        .cast(CastCat.class)
        .map(CastCat::getCode)
        .mapNotNull(CastCatFindRequestMapper::new)
        .mapNotNull(CastCatFindRequestMapper::get)
        .flatMapMany(this.castCatSearchService::action)
        .last()
        .map(new CastCatResponseMapper());
  }

  @QueryMapping(name = "castCatSearch")
  public Flux<CastCat> castCatSearch(
      @Argument("codes") List<String> codes
  ) {
    return Mono.just(codes)
        .map(CastCatSearchRequestMapper::new)
        .mapNotNull(CastCatSearchRequestMapper::get)
        .flatMapMany(this.castCatSearchService::action)
        .map(new CastCatResponseMapper());
  }

}
