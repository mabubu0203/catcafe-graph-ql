package mabubu0203.com.github.cafe.api.controller.location;

import com.netflix.dgs.codegen.types.Location;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.controller.location.helper.request.LocationSearchRequestMapper;
import mabubu0203.com.github.cafe.api.controller.location.helper.response.LocationResponseMapper;
import mabubu0203.com.github.cafe.api.service.location.LocationSearchService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class LocationQueryController {

  private final LocationSearchService locationSearchService;

  @QueryMapping(name = "locationSearch")
  public Flux<Location> locationSearch(
      @Argument("codes") List<String> codes
  ) {
    return Flux.just(new LocationSearchRequestMapper(codes).get())
        .flatMap(this.locationSearchService::action)
        .map(new LocationResponseMapper());
  }

}
