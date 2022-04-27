package mabubu0203.com.github.cafe.api.service.location.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.location.LocationDeleteService;
import mabubu0203.com.github.cafe.api.service.location.impl.converter.input.LocationDeleteServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.location.impl.converter.output.LocationDeleteServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.location.model.input.LocationDeleteServiceInput;
import mabubu0203.com.github.cafe.api.service.location.model.output.LocationDeleteServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class LocationDeleteServiceImpl implements LocationDeleteService {

  private final LocationRepository locationRepository;

  @Override
  @PreAuthorize("hasAuthority('Delete')")
  @Transactional
  public Mono<LocationDeleteServiceOutput> action(LocationDeleteServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Mono.just(input)
        .map(new LocationDeleteServiceInputConverter())
        .flatMap(entity -> this.locationRepository.logicalDelete(entity, receptionTime))
        .map(new LocationDeleteServiceOutputConverter());
  }

  @Override
  public Mono<LocationDeleteServiceOutput> onAfterSave(LocationDeleteServiceOutput output) {
    return Mono.just(output)
        .map(LocationDeleteServiceOutput::locationCode)
        .map(LocationCode::new)
        .flatMap(this.locationRepository::publishEvent)
        .thenReturn(output);
  }

}
