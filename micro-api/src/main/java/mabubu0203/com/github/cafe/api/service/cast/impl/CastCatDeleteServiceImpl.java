package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastCatDeleteService;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatDeleteServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatDeleteServiceOutput;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastCatDeleteServiceImpl implements CastCatDeleteService {

  @Override
  public Mono<CastCatDeleteServiceOutput> action(CastCatDeleteServiceInput input) {
    return Mono.empty();
  }

}
