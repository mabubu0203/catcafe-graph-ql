package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastCatRegisterService;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastCatRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastCatRegisterServiceOutput;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastCatRegisterServiceImpl implements CastCatRegisterService {

  @Override
  public Mono<CastCatRegisterServiceOutput> action(CastCatRegisterServiceInput input) {
    return Mono.empty();
  }

}
