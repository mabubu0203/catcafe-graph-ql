package mabubu0203.com.github.cafe.api.service.cast.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastCatModifyService;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.input.CastCatModifyServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.output.CastCatModifyServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatModifyServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatModifyServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastCatModifyServiceImpl implements CastCatModifyService {

  private final CastRepository castRepository;

  @Override
  @Transactional
  public Mono<CastCatModifyServiceOutput> action(CastCatModifyServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Optional.of(input)
        .map(new CastCatModifyServiceInputConverter())
        .map(entity -> this.castRepository.modify(entity, receptionTime))
        .orElseThrow(RuntimeException::new)
        .flatMap(this.castRepository::findByCode)
        .map(new CastCatModifyServiceOutputConverter());
  }

}
