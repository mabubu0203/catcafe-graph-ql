package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastRegisterService;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastRegisterServiceOutput;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastResisterServiceImpl implements CastRegisterService {

  @Override
  public Mono<CastRegisterServiceOutput> action(CastRegisterServiceInput input) {
    return Mono.empty();
  }

}
