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
          + "          authentication_user.code"
          + "        , authentication_user.username"
          + "        , authentication_user.password"
          + "        , user_role.role_key"
          + "      FROM"
          + "        authentication_user"
          + "      INNER JOIN user_role ON authentication_user.code = user_role.authentication_user_code"
          + "      INNER JOIN role ON user_role.role_key = role.role_key"
          + "      WHERE"
          + "        authentication_user.username = :username"
  )
  Flux<UserAndRole> selectUserAndRolesSearchByUsername(String username);

}
