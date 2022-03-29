package mabubu0203.com.github.cafe.api.controller.cast;

import com.netflix.dgs.codegen.types.Cast;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.controller.cast.helper.request.CastSearchRequestMapper;
import mabubu0203.com.github.cafe.api.controller.cast.helper.response.CastResponseMapper;
import mabubu0203.com.github.cafe.api.service.cast.CastSearchService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CastQueryController {

  private final CastSearchService castSearchService;

  @QueryMapping(name = "castSearch")
  public Flux<Cast> castSearch(
      @Argument("codes") List<String> codes,
      @Argument("locationCodes") List<String> locationCodes
  ) {
    return Mono.just(new CastSearchRequestMapper(codes, locationCodes))
        .map(CastSearchRequestMapper::get)
        .flatMapMany(this.castSearchService::action)
        .map(new CastResponseMapper());
  }

}
