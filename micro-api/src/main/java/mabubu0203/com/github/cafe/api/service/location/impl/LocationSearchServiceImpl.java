package mabubu0203.com.github.cafe.api.service.location.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.location.LocationSearchService;
import mabubu0203.com.github.cafe.api.service.location.impl.converter.input.LocationSearchServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.location.impl.converter.output.LocationServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.location.model.input.LocationSearchServiceInput;
import mabubu0203.com.github.cafe.api.service.location.model.output.LocationServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class LocationSearchServiceImpl implements LocationSearchService {

  private final LocationRepository locationRepository;

  @Override
  public Flux<LocationServiceOutput> action(LocationSearchServiceInput input) {
    return Optional.of(input)
        .map(new LocationSearchServiceInputConverter())
        .map(this.locationRepository::search)
        .orElseThrow(RuntimeException::new)
        .map(new LocationServiceOutputConverter());
  }

}
