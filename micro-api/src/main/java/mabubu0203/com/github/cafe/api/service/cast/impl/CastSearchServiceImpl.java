package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastSearchService;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.input.CastCatSearchServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.input.CastSearchServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.output.CastCatServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.output.CastServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastSearchServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CastSearchServiceImpl implements CastSearchService {

  private final CastRepository castRepository;

  @Override
  @Transactional(readOnly = true)
  public Flux<CastServiceOutput> action(CastSearchServiceInput input) {
    return Optional.of(input)
        .map(new CastSearchServiceInputConverter())
        .map(this.castRepository::search)
        .orElseThrow(RuntimeException::new)
        .map(new CastServiceOutputConverter());
  }
}
