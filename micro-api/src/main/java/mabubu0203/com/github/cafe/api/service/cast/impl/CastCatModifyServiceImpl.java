package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastCatModifyService;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.input.CastCatModifyServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.output.CastCatServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatModifyServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastCatModifyServiceImpl implements CastCatModifyService {

  private final CastRepository castRepository;

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @Transactional
  public Mono<CastCatServiceOutput> action(CastCatModifyServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Mono.just(input)
        .map(new CastCatModifyServiceInputConverter())
        .flatMap(entity -> this.castRepository.modify(entity, receptionTime))
        .flatMap(this.castRepository::findByCode)
        .map(new CastCatServiceOutputConverter());
  }

  @Override
  public Mono<CastCatServiceOutput> onAfterSave(CastCatServiceOutput output) {
    return null;
  }

}
