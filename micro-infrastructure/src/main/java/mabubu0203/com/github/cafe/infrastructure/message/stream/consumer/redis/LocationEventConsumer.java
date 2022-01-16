package mabubu0203.com.github.cafe.infrastructure.message.stream.consumer.redis;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Log
@Service
@RequiredArgsConstructor
public class LocationEventConsumer
    implements StreamListener<String, ObjectRecord<String, LocationCode>> {

  private final ReactiveRedisTemplate<String, String> redisTemplate;

  private AtomicInteger atomicInteger = new AtomicInteger(0);

  @Override
  public void onMessage(ObjectRecord<String, LocationCode> record) {
    log.info("Consumer:locationCode:" + record.getValue().value());
    this.atomicInteger.incrementAndGet();
  }

  @Scheduled(fixedRate = 100)
  public void showPublishedEventsSoFar() {
    log.info("Total Consumer :: " + this.atomicInteger.get());
  }

}
