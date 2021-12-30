package mabubu0203.com.github.cafe.api.controller;

import mabubu0203.com.github.cafe.api.model.Cast;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CastQueryController {

  @QueryMapping
  public Mono<Cast> castFind(@Argument Integer id) {
    return Mono.just(
        Cast.builder()
            .id(id)
            .firstAttendanceDate("")
            .lastAttendanceDate("")
            .memo("")
            .build());
  }

  @QueryMapping
  public Flux<Cast> castSearch() {
    return Flux.just(
        Cast.builder()
            .id(1)
            .firstAttendanceDate("")
            .lastAttendanceDate("")
            .memo("")
            .build());
  }

}
