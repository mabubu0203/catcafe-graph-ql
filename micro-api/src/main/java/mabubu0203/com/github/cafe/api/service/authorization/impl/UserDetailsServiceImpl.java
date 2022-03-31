package mabubu0203.com.github.cafe.api.service.authorization.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;
import mabubu0203.com.github.cafe.domain.repository.authorization.AuthenticationUserRepository;
import mabubu0203.com.github.cafe.domain.value.authorization.Role;
import mabubu0203.com.github.cafe.domain.value.authorization.Username;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final AuthenticationUserRepository authenticationUserRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return Mono.just(username)
        .map(Username::new)
        .flatMap(this.authenticationUserRepository::findByUsername)
        .switchIfEmpty(
            Mono.error(new UsernameNotFoundException("User [" + username + "] not found."))
        )
        .map(this::createUser)
        .block();
  }

  private UserDetails createUser(AuthenticationUserEntity user) {
    return new User(
        user.username().value(),
        user.password(),
        user.roles().stream()
            .map(Role::value)
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toSet())
    );
  }

}
