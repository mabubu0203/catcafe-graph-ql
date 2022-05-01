package mabubu0203.com.github.cafe.infrastructure.source.r2dbc;

import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.UserHasRoleTable;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHasRoleTableSource extends R2dbcRepository<UserHasRoleTable, Integer> {

}
