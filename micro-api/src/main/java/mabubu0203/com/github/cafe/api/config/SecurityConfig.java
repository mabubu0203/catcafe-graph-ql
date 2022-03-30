package mabubu0203.com.github.cafe.api.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.CsrfSpec;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

  @Bean
  SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
    return http
        .csrf(CsrfSpec::disable)
        .authorizeExchange(requests -> requests.anyExchange().permitAll())
        .httpBasic(withDefaults())
        .build();
  }

  @Bean
  public MapReactiveUserDetailsService userDetailsService() {
    User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
    var user = userBuilder.username("user").password("password").roles("USER").build();
    var admin = userBuilder.username("admin").password("admin").roles("USER", "ADMIN").build();
    return new MapReactiveUserDetailsService(user, admin);
  }

}
