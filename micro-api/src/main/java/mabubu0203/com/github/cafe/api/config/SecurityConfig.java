package mabubu0203.com.github.cafe.api.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Collection;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;
import mabubu0203.com.github.cafe.domain.repository.authorization.AuthenticationUserRepository;
import mabubu0203.com.github.cafe.domain.value.authorization.Permission;
import mabubu0203.com.github.cafe.domain.value.authorization.Role;
import mabubu0203.com.github.cafe.domain.value.authorization.Username;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.CsrfSpec;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final AuthenticationUserRepository authenticationUserRepository;

  @Bean
  SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
    return http
        .csrf(CsrfSpec::disable)
        .authorizeExchange(requests -> requests.anyExchange().permitAll())
        .httpBasic(withDefaults())
        .build();
  }

  @Bean
  ReactiveUserDetailsService userDetailsService() {
    return username -> Mono.just(username)
        .map(Username::new)
        .flatMap(this.authenticationUserRepository::findByUsername)
        .switchIfEmpty(
            Mono.error(new UsernameNotFoundException("User [" + username + "] not found."))
        )
        .map(this::createUser);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  private UserDetails createUser(AuthenticationUserEntity user) {
    return new User(
        user.username().value(),
        user.password(),
        user.roles().stream()
            .flatMap(role -> role.permissions().stream())
            .map(Permission::key)
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toSet())
    );
  }

}
