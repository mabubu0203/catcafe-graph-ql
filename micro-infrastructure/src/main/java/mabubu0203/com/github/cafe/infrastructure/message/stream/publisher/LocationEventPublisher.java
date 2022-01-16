package mabubu0203.com.github.cafe.infrastructure.message.stream.publisher;

import mabubu0203.com.github.cafe.domain.value.code.LocationCode;

public interface LocationEventPublisher {

  void publishEvent(LocationCode locationCode);

}
