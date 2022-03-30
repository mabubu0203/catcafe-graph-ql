package mabubu0203.com.github.cafe.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.CsrfSpec;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity

public class SecurityConfig {

  @Bean
  SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
    return http
        .csrf(spec -> spec.disable())
        // Demonstrate that method security works
        // Best practice to use both for defense in depth
        .authorizeExchange(requests -> requests.anyExchange().permitAll())
        .httpBasic(withDefaults())
        .build();
  }

  @Bean
  public MapReactiveUserDetailsService userDetailsService() {
    var user = User
        .withUsername("user")
        .password(passwordEncoder().encode("password"))
        .roles("USER")
        .build();
    var admin = User
        .withUsername("admin")
        .password(passwordEncoder().encode("password"))
        .roles("USER", "ADMIN")
        .build();
    return new MapReactiveUserDetailsService(user, admin);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
