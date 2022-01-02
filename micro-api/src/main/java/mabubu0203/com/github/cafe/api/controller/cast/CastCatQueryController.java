package mabubu0203.com.github.cafe.api.controller.cast;

import com.netflix.dgs.codegen.types.CastCat;
import graphql.relay.Connection;
import graphql.relay.DefaultConnection;
import graphql.relay.DefaultPageInfo;
import graphql.relay.Edge;
import java.util.ArrayList;
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
  public Connection<CastCat> castCatSearch(
      @Argument int first,
      @Argument String after,
      @Argument int last,
      @Argument String before
  ) {
    var edges = new ArrayList<Edge<CastCat>>();
    var pageInfo = new DefaultPageInfo(null, null, true, true);
    return new DefaultConnection<>(edges, pageInfo);
//    return new SimpleListConnection<>(Collections.singletonList(new CastCat())).get(env);
//    return Mono.just("")
//        .map(new CastCatFindRequestMapper())
//        .map(this.castCatSearchService::action)
//        .mapNotNull(Flux::blockFirst)
//        .map(new CastCatFindResponseMapper());
  }

}
