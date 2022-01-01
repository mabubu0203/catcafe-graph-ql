package mabubu0203.com.github.cafe.api.service.cast.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastCatSearchService;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.input.CastCatSearchServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.output.CastCatSearchServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatSearchServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatSearchServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CastCatSearchServiceImpl implements CastCatSearchService {

  private final CastRepository castRepository;

  @Override
  @Transactional(readOnly = true)
  public Flux<CastCatSearchServiceOutput> action(CastCatSearchServiceInput input) {
    return Optional.of(input)
        .map(new CastCatSearchServiceInputConverter())
        .map(this.castRepository::search)
        .orElseThrow(RuntimeException::new)
        .map(new CastCatSearchServiceOutputConverter());
  }

}
