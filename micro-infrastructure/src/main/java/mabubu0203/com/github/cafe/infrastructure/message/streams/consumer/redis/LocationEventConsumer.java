package mabubu0203.com.github.cafe.infrastructure.message.streams.consumer.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.StreamInfo.XInfoGroup;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

@Log
@Component
@RequiredArgsConstructor
public class LocationEventConsumer
    implements StreamListener<String, ObjectRecord<String, LocationCode>> {

  private final ReactiveRedisTemplate<String, String> redisTemplate;
  private final LocationRepository locationRepository;

  @Value("${message.streams.location.stream-key}")
  private String streamKey;

  @Override
  public void onMessage(ObjectRecord<String, LocationCode> record) {
    var locationCode = record.getValue();
    log.info("Consumer:locationCode:" + locationCode.value());
    this.redisTemplate
        .opsForStream()
        .groups(this.streamKey)
        .map(XInfoGroup::groupName)
        .subscribe(log::info);

    this.locationRepository.findByCode(locationCode);
  }

}
