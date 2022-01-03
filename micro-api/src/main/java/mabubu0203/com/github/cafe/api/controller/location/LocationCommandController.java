package mabubu0203.com.github.cafe.api.controller.location;

import com.netflix.dgs.codegen.types.Location;
import com.netflix.dgs.codegen.types.LocationCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class LocationCommandController {

  @MutationMapping(name = "locationCreate")
  public Mono<Location> locationCreate(
      @Argument("input") LocationCommand input
  ) {
    return Mono.empty();
  }

  @MutationMapping(name = "locationUpdate")
  public Mono<Location> locationUpdate(
      @Argument("code") String code,
      @Argument("input") LocationCommand input,
      @Argument("version") Integer version
  ) {
    return Mono.empty();
  }

  @MutationMapping(name = "locationDelete")
  public Mono<Location> locationDelete(
      @Argument("code") String code,
      @Argument("version") Integer version
  ) {
    return Mono.empty();
  }
}
