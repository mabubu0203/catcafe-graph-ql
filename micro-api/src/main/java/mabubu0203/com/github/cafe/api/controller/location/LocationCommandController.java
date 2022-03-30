package mabubu0203.com.github.cafe.api.controller.location;

import com.netflix.dgs.codegen.types.Location;
import com.netflix.dgs.codegen.types.LocationCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.controller.location.helper.request.LocationCreateRequestMapper;
import mabubu0203.com.github.cafe.api.controller.location.helper.request.LocationDeleteRequestMapper;
import mabubu0203.com.github.cafe.api.controller.location.helper.request.LocationUpdateRequestMapper;
import mabubu0203.com.github.cafe.api.controller.location.helper.response.LocationDeleteResponseMapper;
import mabubu0203.com.github.cafe.api.controller.location.helper.response.LocationResponseMapper;
import mabubu0203.com.github.cafe.api.service.location.LocationDeleteService;
import mabubu0203.com.github.cafe.api.service.location.LocationModifyService;
import mabubu0203.com.github.cafe.api.service.location.LocationRegisterService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class LocationCommandController {

  private final LocationRegisterService locationRegisterService;
  private final LocationModifyService locationModifyService;
  private final LocationDeleteService locationDeleteService;

  @MutationMapping(name = "locationCreate")
  public Mono<Location> locationCreate(
      @Argument("input") LocationCommand input
  ) {
    return Mono.just(input)
        .map(new LocationCreateRequestMapper())
        .flatMap(this.locationRegisterService::action)
        .flatMap(this.locationRegisterService::onAfterSave)
        .map(new LocationResponseMapper());
  }

  @MutationMapping(name = "locationUpdate")
  public Mono<Location> locationUpdate(
      @Argument("code") String code,
      @Argument("input") LocationCommand input,
      @Argument("version") Integer version
  ) {
    return Mono.just(input)
        .map(new LocationUpdateRequestMapper(code, version))
        .flatMap(this.locationModifyService::action)
        .flatMap(this.locationRegisterService::onAfterSave)
        .map(new LocationResponseMapper());
  }

  @MutationMapping(name = "locationDelete")
  public Mono<String> locationDelete(
      @Argument("code") String code,
      @Argument("version") Integer version
  ) {
    return Mono.just(code)
        .map(new LocationDeleteRequestMapper(version))
        .flatMap(this.locationDeleteService::action)
        .flatMap(this.locationDeleteService::onAfterSave)
        .map(new LocationDeleteResponseMapper());
  }
}
