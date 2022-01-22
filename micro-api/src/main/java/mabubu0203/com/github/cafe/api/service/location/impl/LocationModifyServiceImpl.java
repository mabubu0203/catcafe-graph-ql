package mabubu0203.com.github.cafe.api.service.location.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.location.LocationModifyService;
import mabubu0203.com.github.cafe.api.service.location.model.input.LocationModifyServiceInput;
import mabubu0203.com.github.cafe.api.service.location.model.output.LocationServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class LocationModifyServiceImpl implements LocationModifyService {

  private final LocationRepository locationRepository;

  @Override
  @Transactional
  public Mono<LocationServiceOutput> action(LocationModifyServiceInput input) {
    return null;
  }

  @Override
  public Mono<LocationServiceOutput> onAfterSave(LocationServiceOutput output) {
    return null;
  }

}
