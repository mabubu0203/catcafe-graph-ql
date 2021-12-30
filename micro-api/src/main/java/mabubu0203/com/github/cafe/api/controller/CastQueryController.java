package mabubu0203.com.github.cafe.api.controller;

import com.netflix.dgs.codegen.types.Cast;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CastQueryController {

  @QueryMapping
  public Mono<Cast> castFind(@Argument String id) {
    return Mono.just(new Cast(id, "a", "b", "c"));
  }

  @QueryMapping
  public Flux<Cast> castSearch() {
    return Flux.just(new Cast("id", "a", "b", "c"));
  }

}
