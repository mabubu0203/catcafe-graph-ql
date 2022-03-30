package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastDeleteService;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.input.CastDeleteServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.output.CastDeleteServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastDeleteServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastDeleteServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastDeleteServiceImpl implements CastDeleteService {

  private final CastRepository castRepository;

  @Override
  @Transactional
  public Mono<CastDeleteServiceOutput> action(CastDeleteServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Mono.just(input)
        .map(new CastDeleteServiceInputConverter())
        .flatMap(entity -> this.castRepository.logicalDelete(entity, receptionTime))
        .map(new CastDeleteServiceOutputConverter());
  }

  @Override
  public Mono<CastDeleteServiceOutput> onAfterSave(CastDeleteServiceOutput output) {
    return null;
  }

}
