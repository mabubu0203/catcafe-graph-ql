package mabubu0203.com.github.cafe.api.controller.location;

import com.netflix.dgs.codegen.types.Cast;
import com.netflix.dgs.codegen.types.Location;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.controller.location.helper.request.LocationFindRequestMapper;
import mabubu0203.com.github.cafe.api.controller.location.helper.request.LocationSearchRequestMapper;
import mabubu0203.com.github.cafe.api.controller.location.helper.response.LocationResponseMapper;
import mabubu0203.com.github.cafe.api.service.location.LocationSearchService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class LocationQueryController {

  private final LocationSearchService locationSearchService;

  @SchemaMapping(field = "location")
  public Mono<Location> location(Cast cast) {
    return Flux.just(cast)
        .map(Cast::getLocation)
        .cast(Location.class)
        .map(Location::getCode)
        .map(code -> new LocationFindRequestMapper(code).get())
        .flatMap(this.locationSearchService::action)
        .last()
        .map(new LocationResponseMapper());
  }

  @QueryMapping(name = "locationSearch")
  public Flux<Location> locationSearch(
      @Argument("codes") List<String> codes
  ) {
    return Flux.just(new LocationSearchRequestMapper(codes).get())
        .flatMap(this.locationSearchService::action)
        .map(new LocationResponseMapper());
  }

}
