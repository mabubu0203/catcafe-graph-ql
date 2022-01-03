package mabubu0203.com.github.cafe.api.service.location.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.location.LocationSearchService;
import mabubu0203.com.github.cafe.api.service.location.impl.converter.input.LocationSearchServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.location.impl.converter.output.LocationServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.location.model.input.LocationSearchServiceInput;
import mabubu0203.com.github.cafe.api.service.location.model.output.LocationServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class LocationSearchServiceImpl implements LocationSearchService {

  private final LocationRepository locationRepository;

  @Override
  @Transactional(readOnly = true)
  public Flux<LocationServiceOutput> action(LocationSearchServiceInput input) {
    return Flux.just(input)
        .map(new LocationSearchServiceInputConverter())
        .flatMap(this.locationRepository::search)
        .map(new LocationServiceOutputConverter());
  }

}
