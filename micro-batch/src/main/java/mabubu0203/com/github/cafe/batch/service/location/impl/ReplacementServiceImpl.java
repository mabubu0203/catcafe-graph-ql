package mabubu0203.com.github.cafe.batch.service.location.impl;

import java.time.Instant;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.batch.service.location.ReplacementService;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplacementServiceImpl implements ReplacementService {

  private final LocationRepository locationRepository;

  @Override
  public void replacement() {
    this.locationRepository.replacement(Instant.now());
  }

}
