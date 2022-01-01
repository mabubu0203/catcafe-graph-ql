package mabubu0203.com.github.cafe.common.controller.helper.request;

import java.util.function.Supplier;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;
import reactor.core.publisher.Mono;

// Mono -> Optional
public interface SearchRequestMapper<I extends ServiceInput> extends Supplier<Mono<I>> {

}
