package mabubu0203.com.github.cafe.api.controller.cast;

import com.netflix.dgs.codegen.types.CastCat;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CastCatQueryController {

  @QueryMapping
  public Mono<CastCat> castCatFind(
      @Argument("code") String code
  ) {
    return Mono.just(
        CastCat.newBuilder()
            .code(code)
            .build());
  }

  @QueryMapping
  public Flux<CastCat> castCatSearch() {
    return Flux.just(
        CastCat.newBuilder()
            .code("")
            .build());
  }

}