package mabubu0203.com.github.cafe.infrastructure.message.streams.consumer.redis;

import java.time.Instant;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationEventConsumer
    implements StreamListener<String, ObjectRecord<String, LocationCode>> {

  private final LocationRepository locationRepository;

  @Override
  public void onMessage(ObjectRecord<String, LocationCode> record) {
    var now = Instant.now();
    this.locationRepository.replacement(record.getValue(), now).subscribe();
  }

}
