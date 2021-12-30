package mabubu0203.com.github.cafe.api;

import mabubu0203.com.github.cafe.api.config.ContextWebFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApp {

  public static void main(String[] args) {
    SpringApplication.run(ApiApp.class, args);
  }

  @Bean
  ContextWebFilter reactorContextWebFilter() {
    return new ContextWebFilter();
  }

}
