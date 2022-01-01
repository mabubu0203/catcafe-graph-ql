package mabubu0203.com.github.cafe.common.service;

import mabubu0203.com.github.cafe.common.service.model.ServiceInput;
import mabubu0203.com.github.cafe.common.service.model.ServiceOutput;
import reactor.core.publisher.Flux;

public interface ReadApplicationService<I extends ServiceInput, O extends ServiceOutput> {

  Flux<O> action(I input);

}
