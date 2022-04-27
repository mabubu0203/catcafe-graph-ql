package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastCatDeleteService;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.input.CastCatDeleteServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.output.CastCatDeleteServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatDeleteServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatDeleteServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastCatDeleteServiceImpl implements CastCatDeleteService {

  private final CastRepository castRepository;

  @Override
  @PreAuthorize("hasAuthority('Delete')")
  @Transactional
  public Mono<CastCatDeleteServiceOutput> action(CastCatDeleteServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Mono.just(input)
        .map(new CastCatDeleteServiceInputConverter())
        .flatMap(entity -> this.castRepository.logicalDelete(entity, receptionTime))
        .map(new CastCatDeleteServiceOutputConverter());
  }

  @Override
  public Mono<CastCatDeleteServiceOutput> onAfterSave(CastCatDeleteServiceOutput output) {
    return null;
  }

}
