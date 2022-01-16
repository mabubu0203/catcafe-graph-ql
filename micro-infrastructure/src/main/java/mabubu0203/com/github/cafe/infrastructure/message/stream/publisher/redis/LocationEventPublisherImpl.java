package mabubu0203.com.github.cafe.infrastructure.message.stream.publisher.redis;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import mabubu0203.com.github.cafe.infrastructure.message.stream.publisher.LocationEventPublisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Log
@Service
@RequiredArgsConstructor
public class LocationEventPublisherImpl implements LocationEventPublisher {

  private final ReactiveRedisTemplate<String, String> redisTemplate;

  @Value("${stream.key}")
  private String streamKey;

  private AtomicInteger atomicInteger = new AtomicInteger(0);

  @Override
  public void publishEvent(LocationCode locationCode) {
    ObjectRecord<String, LocationCode> record = StreamRecords.newRecord()
        .ofObject(locationCode)
        .withStreamKey(this.streamKey);
    this.redisTemplate
        .opsForStream()
        .add(record)
        .subscribe(a -> log.info(a.toString()));
    this.atomicInteger.incrementAndGet();
  }

  @Scheduled(fixedRate = 100)
  public void showPublishedEventsSoFar() {
    log.info("Total Events :: " + atomicInteger.get());
  }

}
