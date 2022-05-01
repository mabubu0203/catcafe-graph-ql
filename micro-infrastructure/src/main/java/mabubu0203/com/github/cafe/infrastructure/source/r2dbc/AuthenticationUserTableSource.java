package mabubu0203.com.github.cafe.infrastructure.source.r2dbc;

import java.util.Collection;
import mabubu0203.com.github.cafe.common.source.r2dbc.TableSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.AuthenticationUserTable;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.RoleAndPermissions;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AuthenticationUserTableSource
    extends TableSource<AuthenticationUserTable, Integer> {

  Mono<AuthenticationUserTable> findByUsername(String username);

  @Query(
      "SELECT"
          + "        role.role_key AS role_key"
          + "        , GROUP_CONCAT(permission.permission_key SEPARATOR ',') AS permission_keys"
          + "      FROM"
          + "        authentication_user"
          + "      INNER JOIN user_has_role ON authentication_user.code = user_has_role.authentication_user_code"
          + "      INNER JOIN role ON user_has_role.role_key = role.role_key"
          + "      INNER JOIN role_has_permission ON role.role_key = role_has_permission.role_key"
          + "      INNER JOIN permission ON role_has_permission.permission_key = permission.permission_key"
          + "      WHERE"
          + "        authentication_user.username = :username"
          + "      GROUP BY"
          + "        role.role_key"
  )
  Flux<RoleAndPermissions> selectRoleAndPermissionsSearchByUsername(
      @Param("username") String username
  );

  @Query(
      "SELECT"
          + "        role.role_key AS role_key"
          + "        , GROUP_CONCAT(permission.permission_key SEPARATOR ',') AS permission_keys"
          + "      FROM"
          + "        role"
          + "      INNER JOIN role_has_permission ON role.role_key = role_has_permission.role_key"
          + "      INNER JOIN permission ON role_has_permission.permission_key = permission.permission_key"
          + "      WHERE"
          + "        role.role_key IN (:roleKeys)"
          + "      GROUP BY"
          + "        role.role_key"
  )
  Flux<RoleAndPermissions> selectRoleAndPermissionsSearchByRoleKeys(
      @Param("roleKeys") Collection<String> roleKeys
  );

}
