package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastDeleteService;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastDeleteServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastDeleteServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastDeleteServiceImpl implements CastDeleteService {

  private final CastRepository castRepository;

  @Override
  public Mono<CastDeleteServiceOutput> action(CastDeleteServiceInput input) {
    return Mono.empty();
  }

}
