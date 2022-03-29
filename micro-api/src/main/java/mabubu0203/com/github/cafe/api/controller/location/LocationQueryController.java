package mabubu0203.com.github.cafe.api.controller.location;

import com.netflix.dgs.codegen.types.Cast;
import com.netflix.dgs.codegen.types.Location;
import com.netflix.dgs.codegen.types.Notice;
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

  @SchemaMapping(field = "location", typeName = "Notice")
  public Mono<Location> location(Notice notice) {
    return Mono.just(notice)
        .map(Notice::getLocation)
        .cast(Location.class)
        .map(Location::getCode)
        .mapNotNull(LocationFindRequestMapper::new)
        .mapNotNull(LocationFindRequestMapper::get)
        .flatMapMany(this.locationSearchService::action)
        .last()
        .map(new LocationResponseMapper());
  }

  @SchemaMapping(field = "location", typeName = "Cast")
  public Mono<Location> location(Cast cast) {
    return Mono.just(cast)
        .map(Cast::getLocation)
        .cast(Location.class)
        .map(Location::getCode)
        .mapNotNull(LocationFindRequestMapper::new)
        .mapNotNull(LocationFindRequestMapper::get)
        .flatMapMany(this.locationSearchService::action)
        .last()
        .map(new LocationResponseMapper());
  }

  @QueryMapping(name = "locationSearch")
  public Flux<Location> locationSearch(
      @Argument("codes") List<String> codes
  ) {
    return Mono.just(codes)
        .map(LocationSearchRequestMapper::new)
        .map(LocationSearchRequestMapper::get)
        .flatMapMany(this.locationSearchService::action)
        .map(new LocationResponseMapper());
  }

}
