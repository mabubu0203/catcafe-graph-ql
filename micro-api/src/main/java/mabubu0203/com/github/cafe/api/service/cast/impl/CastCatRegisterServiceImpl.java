package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastCatRegisterService;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.input.CastCatRegisterServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.output.CastCatServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastCatRegisterServiceImpl implements CastCatRegisterService {

  private final CastRepository castRepository;

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @Transactional
  public Mono<CastCatServiceOutput> action(CastCatRegisterServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Mono.just(input)
        .map(new CastCatRegisterServiceInputConverter())
        .flatMap(entity -> this.castRepository.register(entity, receptionTime))
        .flatMap(this.castRepository::findByCode)
        .map(new CastCatServiceOutputConverter());
  }

  @Override
  public Mono<CastCatServiceOutput> onAfterSave(CastCatServiceOutput output) {
    return null;
  }

}
