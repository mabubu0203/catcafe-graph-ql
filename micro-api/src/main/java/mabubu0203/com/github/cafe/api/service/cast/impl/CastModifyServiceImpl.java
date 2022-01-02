package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastModifyService;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastModifyServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastServiceOutput;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastModifyServiceImpl implements CastModifyService {

  @Override
  public Mono<CastServiceOutput> action(CastModifyServiceInput input) {
    return Mono.empty();
  }

}
