package mabubu0203.com.github.cafe.api.service.location.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.location.LocationModifyService;
import mabubu0203.com.github.cafe.api.service.location.impl.converter.input.LocationModifyServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.location.impl.converter.output.LocationServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.location.model.input.LocationModifyServiceInput;
import mabubu0203.com.github.cafe.api.service.location.model.output.LocationServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class LocationModifyServiceImpl implements LocationModifyService {

  private final LocationRepository locationRepository;

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @Transactional
  public Mono<LocationServiceOutput> action(LocationModifyServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Mono.just(input)
        .map(new LocationModifyServiceInputConverter())
        .flatMap(entity -> this.locationRepository.modify(entity, receptionTime))
        .flatMap(this.locationRepository::findByCode)
        .map(new LocationServiceOutputConverter());
  }

  @Override
  public Mono<LocationServiceOutput> onAfterSave(LocationServiceOutput output) {
    return Mono.just(output)
        .map(LocationServiceOutput::locationCode)
        .map(LocationCode::new)
        .flatMap(this.locationRepository::publishEvent)
        .thenReturn(output);
  }

}
