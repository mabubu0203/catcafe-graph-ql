package mabubu0203.com.github.cafe.infrastructure.source.r2dbc;

import mabubu0203.com.github.cafe.common.source.r2dbc.TableSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.AuthenticationUserTable;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.UserAndRole;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AuthenticationUserTableSource extends
    TableSource<AuthenticationUserTable, Integer> {

  @Query(
      "SELECT"
          + "        authentication_user.username"
          + "        , authentication_user.password"
          + "        , user_role.role_key AS roleKey"
          + "        , role_permission.permission_key AS permissionKey"
          + "      FROM"
          + "        authentication_user"
          + "      INNER JOIN user_role ON authentication_user.code = user_role.authentication_user_code"
          + "      INNER JOIN role ON user_role.role_key = role.key"
          + "      INNER JOIN role_permission ON role.key = role_permission.role_key"
          + "      INNER JOIN permission ON role_permission.permission_key = permission.key"
          + "      WHERE"
          + "        authentication_user.username = :username"
  )
  Flux<UserAndRole> selectUserAndRolesSearchByUsername(String username);

}
