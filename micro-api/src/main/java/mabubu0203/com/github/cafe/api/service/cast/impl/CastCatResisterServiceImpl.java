package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastCatResisterService;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatResisterServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatResisterServiceOutput;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastCatResisterServiceImpl implements CastCatResisterService {

  @Override
  public Mono<CastCatResisterServiceOutput> action(CastCatResisterServiceInput input) {
    return Mono.empty();
  }

}
