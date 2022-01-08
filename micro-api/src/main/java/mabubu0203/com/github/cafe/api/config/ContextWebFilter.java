package mabubu0203.com.github.cafe.api.config;

import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * WebFilter that inserts a key-value pair into the Reactor context which is transferred to and
 * accessible in Reactor data fetchers.
 */
public class ContextWebFilter implements WebFilter {

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
    return chain.filter(exchange).contextWrite(context -> context.put("name", "007"));
  }

}
