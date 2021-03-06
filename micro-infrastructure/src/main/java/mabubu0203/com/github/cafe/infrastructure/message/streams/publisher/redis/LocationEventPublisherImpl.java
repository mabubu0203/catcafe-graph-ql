package mabubu0203.com.github.cafe.infrastructure.message.streams.publisher.redis;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.domain.check.message.streams.publisher.LocationEventPublisher;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class LocationEventPublisherImpl implements LocationEventPublisher {

  private final ReactiveRedisTemplate<String, String> redisTemplate;

  @Value("${message.streams.location.stream-key}")
  private String streamKey;

  @Override
  public Mono<String> publish(LocationCode locationCode) {
    var record = StreamRecords.newRecord()
        .in(this.streamKey)
        .ofObject(locationCode)
        .withId(RecordId.autoGenerate());
    return this.redisTemplate
        .opsForStream()
        .add(record)
        .map(RecordId::getValue);
  }

}
