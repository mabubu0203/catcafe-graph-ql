package mabubu0203.com.github.cafe.infrastructure.repository.impl.authorization;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.common.exception.ResourceNotFoundException;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;
import mabubu0203.com.github.cafe.domain.repository.authorization.AuthorizationRepository;
import mabubu0203.com.github.cafe.domain.value.authorization.Permission;
import mabubu0203.com.github.cafe.domain.value.authorization.Role;
import mabubu0203.com.github.cafe.domain.value.authorization.Username;
import mabubu0203.com.github.cafe.domain.value.code.UserCode;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.AuthenticationUserTableSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.UserHasRoleTableSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.AuthenticationUserTable;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.RoleAndPermissions;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class AuthorizationRepositoryImpl implements AuthorizationRepository {

  private final AuthenticationUserTableSource authenticationUserTableSource;
  private final UserHasRoleTableSource userHasRoleTableSource;


  @Override
  public Flux<Role> searchByRoleKeys(List<String> roleKeys) {
    return
        this.authenticationUserTableSource.selectRoleAndPermissionsSearchByRoleKeys(
                (String[]) roleKeys.toArray()
            )
            .map(e -> new Role(
                e.getRoleKey(),
                Arrays.stream(e.getPermissionKeys().split(","))
                    .map(Permission::new)
                    .toList()
            ));
  }

  @Override
  public Mono<AuthenticationUserEntity> findByCode(UserCode userCode) {
    return this.findTable(userCode)
        .map(AuthenticationUserTable::toEntity);
  }

  @Override
  public Mono<AuthenticationUserEntity> findByUsername(Username username) {
    return Mono.just(username)
        .map(Username::value)
        .flatMap(str ->
            this.authenticationUserTableSource.findByUsername(str)
                .map(AuthenticationUserTable::toEntity)
                .flatMap(this::selectUserAndRolesSearchByUsername)
        );
  }

  @Override
  public Mono<UserCode> register(AuthenticationUserEntity entity, LocalDateTime receptionTime) {
    return this.userRegister(entity, receptionTime);
  }

  private Mono<AuthenticationUserTable> findTable(UserCode userCode) {
    return this.authenticationUserTableSource.findByCode(userCode.value())
        .filter(BaseTable::isExists)
        // 404で返却するためのエラーを検討
        .switchIfEmpty(Mono.error(new ResourceNotFoundException("ユーザーが存在しません")));
  }

  private Mono<AuthenticationUserEntity> selectUserAndRolesSearchByUsername(
      AuthenticationUserEntity entity
  ) {
    return
        this.authenticationUserTableSource.selectRoleAndPermissionsSearchByUsername(
                entity.getUsernameValue()
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

  private Mono<UserCode> userRegister(AuthenticationUserEntity entity,
      LocalDateTime receptionTime) {
    return Mono.just(entity)
        .map(this::attach)
        .map(dto -> dto.createdBy(0))
        .flatMap(dto -> this.authenticationUserTableSource.insert(dto, receptionTime))
        .map(AuthenticationUserTable::code)
        .map(UserCode::new);
  }

  // TODO:UserHasRoleTableSourceで一括登録する
  private Mono<UserCode> roleBulkRegister() {
    return Mono.empty();
  }

  private AuthenticationUserTable attach(AuthenticationUserEntity entity) {
    return this.attach(null, entity);
  }

  private AuthenticationUserTable attach(AuthenticationUserTable dto,
      AuthenticationUserEntity entity) {
    return Optional.ofNullable(dto)
        .orElse(new AuthenticationUserTable())
        .attach(entity);
  }

}
