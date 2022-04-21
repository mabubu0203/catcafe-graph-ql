package mabubu0203.com.github.cafe.infrastructure.repository.impl.authorization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;
import mabubu0203.com.github.cafe.domain.repository.authorization.AuthenticationUserRepository;
import mabubu0203.com.github.cafe.domain.value.authorization.Permission;
import mabubu0203.com.github.cafe.domain.value.authorization.Role;
import mabubu0203.com.github.cafe.domain.value.authorization.Username;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.AuthenticationUserTableSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.RoleAndPermissions;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class AuthenticationUserRepositoryImpl implements AuthenticationUserRepository {

  private final AuthenticationUserTableSource authenticationUserTableSource;

  @Override
  public Mono<AuthenticationUserEntity> findByUsername(Username username) {
    return Mono.just(username)
        .map(Username::value)
        .flatMap(str ->
            this.authenticationUserTableSource.findByUsername(str)
                .map(a -> new AuthenticationUserEntity()
                    .username(new Username(a.username()))
                    .password(a.password()))
                .flatMap(this::selectUserAndRolesSearchByUsername)
        )
        .switchIfEmpty(
            Mono.empty()
        );
  }

  private Mono<AuthenticationUserEntity> selectUserAndRolesSearchByUsername(
      AuthenticationUserEntity entity
  ) {
    return this.authenticationUserTableSource.selectUserAndRolesSearchByUsername(
            entity.username().value())
        .collect(() -> entity, this::addRole);
  }

  private boolean addRole(
      AuthenticationUserEntity entity
      , RoleAndPermissions roleAndPermissions
  ) {
    var role = new Role(
        roleAndPermissions.getRoleKey(),
        Arrays.stream(roleAndPermissions.getPermissionKeys().split(",")).map(Permission::new)
            .toList()
    );
    return entity.addRole(role);
  }

}
