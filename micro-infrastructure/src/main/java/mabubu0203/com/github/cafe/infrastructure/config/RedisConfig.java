package mabubu0203.com.github.cafe.infrastructure.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
import org.springframework.data.redis.stream.Subscription;

@Configuration
@RequiredArgsConstructor
public class RedisConfig extends BaseRedisConfig {

  private final StreamListener<String, ObjectRecord<String, LocationCode>> streamListener;

  @Value("${stream.key:purchase-events}")
  private String streamKey;

  @Bean
  public Subscription subscription(RedisConnectionFactory redisConnectionFactory)
      throws UnknownHostException {
    var options = StreamMessageListenerContainer
        .StreamMessageListenerContainerOptions
        .builder()
        .pollTimeout(Duration.ofSeconds(1))
        .targetType(LocationCode.class)
        .build();
    var listenerContainer = StreamMessageListenerContainer
        .create(redisConnectionFactory, options);

    var subscription = listenerContainer.receive(
        Consumer.from(this.streamKey, InetAddress.getLocalHost().getHostName()),
        StreamOffset.create(this.streamKey, ReadOffset.lastConsumed()),
        this.streamListener
    );
    listenerContainer.start();
    return subscription;
  }

}
