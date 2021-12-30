package mabubu0203.com.github.cafe.api.controller.cast;

import com.netflix.dgs.codegen.types.Cast;
import com.netflix.dgs.codegen.types.CastCat;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CastQueryController {

  @QueryMapping
  public Mono<Cast> castFind(
      @Argument("id") Integer id
  ) {
    return Mono.just(
        Cast.newBuilder()
            .id(id)
            .build());
  }

  @QueryMapping
  public Flux<Cast> castSearch() {
    return Flux.just(
        Cast.newBuilder()
            .id(0)
            .build());
  }

  @QueryMapping
  public Mono<CastCat> castCatFind(
      @Argument("id") Integer id
  ) {
    return Mono.just(
        CastCat.newBuilder()
            .id(id)
            .build());
  }

  @QueryMapping
  public Flux<CastCat> castCatSearch() {
    return Flux.just(
        CastCat.newBuilder()
            .id(0)
            .build());
  }
}
