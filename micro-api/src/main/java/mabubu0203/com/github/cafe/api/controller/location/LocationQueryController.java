package mabubu0203.com.github.cafe.api.controller.location;

import com.netflix.dgs.codegen.types.Location;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class LocationQueryController {

  @QueryMapping(name = "locationSearch")
  public Flux<Location> locationSearch(
      @Argument("codes") List<String> codes
  ) {
    return Flux.empty();
  }

}
