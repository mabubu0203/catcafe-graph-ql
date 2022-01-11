package mabubu0203.com.github.cafe.batch;

import mabubu0203.com.github.cafe.domain.DomainCore;
import mabubu0203.com.github.cafe.infrastructure.InfrastructureCore;
import mabubu0203.com.github.cafe.infrastructure.config.R2dbcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(value = {
    R2dbcConfig.class,
    DomainCore.class,
    InfrastructureCore.class,
})
public class BatchApp {

  public static void main(String[] args) {
    SpringApplication.run(BatchApp.class, args);
  }

}
