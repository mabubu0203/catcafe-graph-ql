package mabubu0203.com.github.cafe.infrastructure.repository.impl.authorization;

import java.util.Arrays;
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
                .map(dto -> new AuthenticationUserEntity(dto.username(), dto.password()))
                .flatMap(this::selectUserAndRolesSearchByUsername)
        );
  }

  private Mono<AuthenticationUserEntity> selectUserAndRolesSearchByUsername(
      AuthenticationUserEntity entity
  ) {
    return
        this.authenticationUserTableSource.selectRoleAndPermissionsSearchByUsername(
                entity.username().value()
            )
            .collect(() -> entity, this::addRole);
  }

  private boolean addRole(
      AuthenticationUserEntity entity,
      RoleAndPermissions roleAndPermissions
  ) {
    return
        entity.addRole(
            new Role(
                roleAndPermissions.getRoleKey(),
                Arrays.stream(roleAndPermissions.getPermissionKeys().split(","))
                    .map(Permission::new)
                    .toList()
            )
        );
  }

}
