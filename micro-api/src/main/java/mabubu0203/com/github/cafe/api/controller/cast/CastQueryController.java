package mabubu0203.com.github.cafe.api.controller.cast;

import com.netflix.dgs.codegen.types.Cast;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CastQueryController {

  public Mono<Cast> castFind(
      @Argument("code") String code
  ) {
    return Mono.just(
        Cast.newBuilder()
            .code(code)
            .build());
  }

  @QueryMapping
  public Flux<Cast> castSearch() {
    return Flux.just(
        Cast.newBuilder()
            .code("")
            .build());
  }


}
