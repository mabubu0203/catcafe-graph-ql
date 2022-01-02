package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastSearchService;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastSearchServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastServiceOutput;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CastSearchServiceImpl implements CastSearchService {

  @Override
  @Transactional(readOnly = true)
  public Flux<CastServiceOutput> action(CastSearchServiceInput input) {
    return Flux.empty();
  }
}
