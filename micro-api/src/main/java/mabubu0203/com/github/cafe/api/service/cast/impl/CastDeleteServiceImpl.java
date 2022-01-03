package mabubu0203.com.github.cafe.api.service.cast.impl;

import java.util.Optional;
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
    return Optional.of(input)
        .map(new CastDeleteServiceInputConverter())
        .map(entity -> this.castRepository.logicalDelete(entity, receptionTime))
        .orElseThrow(RuntimeException::new)
        .map(new CastDeleteServiceOutputConverter());
  }

}
