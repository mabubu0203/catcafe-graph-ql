package mabubu0203.com.github.cafe.api;

import mabubu0203.com.github.cafe.api.config.ContextWebFilter;
import mabubu0203.com.github.cafe.domain.DomainCore;
import mabubu0203.com.github.cafe.infrastructure.InfrastructureCore;
import mabubu0203.com.github.cafe.infrastructure.config.ElasticConfig;
import mabubu0203.com.github.cafe.infrastructure.config.R2dbcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(value = {
    ElasticConfig.class,
    R2dbcConfig.class,
    DomainCore.class,
    InfrastructureCore.class,
})
public class ApiApp {

  public static void main(String[] args) {
    SpringApplication.run(ApiApp.class, args);
  }

  @Bean
  ContextWebFilter reactorContextWebFilter() {
    return new ContextWebFilter();
  }

}
