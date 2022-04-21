package mabubu0203.com.github.cafe.infrastructure.repository.impl.authorization;

import java.util.ArrayList;
import java.util.stream.Collector;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;
import mabubu0203.com.github.cafe.domain.repository.authorization.AuthenticationUserRepository;
import mabubu0203.com.github.cafe.domain.value.authorization.Role;
import mabubu0203.com.github.cafe.domain.value.authorization.Username;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.AuthenticationUserTableSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.UserAndRole;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class AuthenticationUserRepositoryImpl implements AuthenticationUserRepository {

  private final AuthenticationUserTableSource authenticationUserTableSource;

  @Override
  public Mono<AuthenticationUserEntity> findByUsername(Username username) {
    Collector<UserAndRole, ?, AuthenticationUserEntity> toAuthenticationUserEntity = Collector.of(
        AuthenticationUserEntity::builder,
        (a, t) -> {
          a.username(new Username(t.getUsername()));
          a.password(t.getPassword());
          var list = new ArrayList<Role>();
          list.add(new Role(t.getRoleKey()));
          a.roles(list);
        },
        (a1, a2) -> {
          var b1 = a1.build();
          var b2 = a2.build();
          b1.roles().addAll(b2.roles());
          return AuthenticationUserEntity.builder()
              .username(b1.username())
              .password(b1.password())
              .roles(b1.roles());
        },
        AuthenticationUserEntity.AuthenticationUserEntityBuilder::build
    );
    return this.authenticationUserTableSource
        .selectUserAndRolesSearchByUsername(username.value())
        .collect(toAuthenticationUserEntity);
  }

}
