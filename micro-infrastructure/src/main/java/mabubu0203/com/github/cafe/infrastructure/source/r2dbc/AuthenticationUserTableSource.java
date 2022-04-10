package mabubu0203.com.github.cafe.infrastructure.source.r2dbc;

import mabubu0203.com.github.cafe.common.source.r2dbc.TableSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.AuthenticationUserTable;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.UserAndRole;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AuthenticationUserTableSource extends
    TableSource<AuthenticationUserTable, Integer> {

  Flux<UserAndRole> selectUserAndRolesSearchByUsername(String username);

}
