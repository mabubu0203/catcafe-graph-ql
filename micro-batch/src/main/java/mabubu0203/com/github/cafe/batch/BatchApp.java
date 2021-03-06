package mabubu0203.com.github.cafe.batch;

import mabubu0203.com.github.cafe.domain.DomainCore;
import mabubu0203.com.github.cafe.infrastructure.InfrastructureCore;
import mabubu0203.com.github.cafe.infrastructure.config.ElasticConfig;
import mabubu0203.com.github.cafe.infrastructure.config.R2dbcConfig;
import mabubu0203.com.github.cafe.infrastructure.config.RedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@Import(value = {
    ElasticConfig.class,
    R2dbcConfig.class,
    RedisConfig.class,
    DomainCore.class,
    InfrastructureCore.class,
})
public class BatchApp {

  public static void main(String[] args) {
    SpringApplication.run(BatchApp.class, args);
  }

}
