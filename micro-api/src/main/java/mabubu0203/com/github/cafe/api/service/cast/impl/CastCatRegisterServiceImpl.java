package mabubu0203.com.github.cafe.api.service.cast.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastCatRegisterService;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.input.CastCatRegisterServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.output.CastCatServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastCatRegisterServiceImpl implements CastCatRegisterService {

  private final CastRepository castRepository;

  @Override
  @Transactional
  public Mono<CastCatServiceOutput> action(CastCatRegisterServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Optional.of(input)
        .map(new CastCatRegisterServiceInputConverter())
        .map(entity -> this.castRepository.register(entity, receptionTime))
        .orElseThrow(RuntimeException::new)
        .flatMap(this.castRepository::findByCode)
        .map(new CastCatServiceOutputConverter());
  }

}
