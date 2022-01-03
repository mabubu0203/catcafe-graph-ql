package mabubu0203.com.github.cafe.api.service.location.impl;

import java.util.Optional;
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
  @Transactional
  public Mono<LocationServiceOutput> action(LocationRegisterServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Optional.of(input)
        .map(new LocationRegisterServiceInputConverter())
        .map(entity -> this.locationRepository.register(entity, receptionTime))
        .orElseThrow(RuntimeException::new)
        .flatMap(this.locationRepository::findByCode)
        .map(new LocationServiceOutputConverter());
  }

}
