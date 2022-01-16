package mabubu0203.com.github.cafe.infrastructure.message.streams.publisher.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import mabubu0203.com.github.cafe.domain.check.message.streams.publisher.LocationEventPublisher;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;

@Log
@Component
@RequiredArgsConstructor
public class LocationEventPublisherImpl implements LocationEventPublisher {

  private final ReactiveRedisTemplate<String, String> redisTemplate;

  @Value("${message.streams.location.stream-key}")
  private String streamKey;

  @Override
  public void publishEvent(LocationCode locationCode) {
    ObjectRecord<String, LocationCode> record = StreamRecords.newRecord()
        .in(this.streamKey)
        .ofObject(locationCode)
        .withId(RecordId.autoGenerate());
    this.redisTemplate
        .opsForStream()
        .add(record)
        .map(RecordId::toString)
        .subscribe(log::info);
  }

}
