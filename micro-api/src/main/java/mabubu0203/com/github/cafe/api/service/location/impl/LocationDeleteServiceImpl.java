package mabubu0203.com.github.cafe.api.service.location.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.location.LocationDeleteService;
import mabubu0203.com.github.cafe.api.service.location.impl.converter.input.LocationDeleteServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.location.impl.converter.output.LocationDeleteServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.location.model.input.LocationDeleteServiceInput;
import mabubu0203.com.github.cafe.api.service.location.model.output.LocationDeleteServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class LocationDeleteServiceImpl implements LocationDeleteService {

  private final LocationRepository locationRepository;

  @Override
  @Transactional
  public Mono<LocationDeleteServiceOutput> action(LocationDeleteServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Mono.just(input)
        .map(new LocationDeleteServiceInputConverter())
        .flatMap(entity -> this.locationRepository.logicalDelete(entity, receptionTime))
        .map(new LocationDeleteServiceOutputConverter());
  }

}
