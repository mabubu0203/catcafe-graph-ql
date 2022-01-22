package mabubu0203.com.github.cafe.domain.check.message.streams.publisher;

import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import reactor.core.publisher.Mono;

public interface LocationEventPublisher {

  Mono<String> publish(LocationCode locationCode);

}
