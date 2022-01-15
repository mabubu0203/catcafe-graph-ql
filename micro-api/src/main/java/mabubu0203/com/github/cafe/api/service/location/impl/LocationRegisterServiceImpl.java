package mabubu0203.com.github.cafe.api.service.location.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.location.LocationRegisterService;
import mabubu0203.com.github.cafe.api.service.location.impl.converter.input.LocationRegisterServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.location.impl.converter.output.LocationServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.location.model.input.LocationRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.location.model.output.LocationServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class LocationRegisterServiceImpl implements LocationRegisterService {

  private final LocationRepository locationRepository;

  @Override
//  @Transactional
  public Mono<LocationServiceOutput> action(LocationRegisterServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Mono.just(input)
        .map(new LocationRegisterServiceInputConverter())
        .flatMap(entity -> this.locationRepository.register(entity, receptionTime))
        .flatMap(this.locationRepository::findByCode)
        .map(new LocationServiceOutputConverter());
  }

}
