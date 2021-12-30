package mabubu0203.com.github.cafe.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.WebFilter;

@SpringBootApplication
public class ApiApp {

  public static void main(String[] args) {
    SpringApplication.run(ApiApp.class, args);
  }

  @Bean
  public WebFilter contextPathWebFilter(ServerProperties serverProperties) {
    var contextPath = serverProperties.getServlet().getContextPath();
    return (exchange, chain) -> {
      var request = exchange.getRequest();
      if (request.getURI().getPath().startsWith(contextPath)) {
        return chain.filter(
            exchange.mutate()
                .request(request.mutate().contextPath(contextPath).build())
                .build());
      }
      return chain.filter(exchange);
    };
  }

}
