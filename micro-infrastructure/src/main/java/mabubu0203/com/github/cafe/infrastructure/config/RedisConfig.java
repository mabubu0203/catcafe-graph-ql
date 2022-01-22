package mabubu0203.com.github.cafe.infrastructure.config;

import java.time.Duration;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.common.config.BaseRedisConfig;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.stream.Consumer;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.ReadOffset;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;

@Configuration
@RequiredArgsConstructor
public class RedisConfig extends BaseRedisConfig {

  private final RedisConnectionFactory connectionFactory;
  private final StreamListener<String, ObjectRecord<String, LocationCode>> locationCodeListener;

  @Value("${message.streams.location.group-name}")
  private String groupName;

  @Value("${message.streams.location.stream-key}")
  private String streamKey;

  @Bean(initMethod = "start", destroyMethod = "stop")
  public StreamMessageListenerContainer<String, ObjectRecord<String, LocationCode>> locationCodeListenerContainer() {

    var options = StreamMessageListenerContainer
        .StreamMessageListenerContainerOptions
        .builder()
        .pollTimeout(Duration.ofSeconds(1))
        .targetType(LocationCode.class)
        .build();

    var container = StreamMessageListenerContainer
        .create(this.connectionFactory, options);

    container.receive(
        Consumer.from(this.groupName, this.streamKey),
        StreamOffset.create(this.streamKey, ReadOffset.lastConsumed()),
        this.locationCodeListener);

    return container;
  }

}
