package mabubu0203.com.github.cafe.infrastructure.source.r2dbc;

import mabubu0203.com.github.cafe.common.source.r2dbc.TableSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.RoleTable;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleTableSource extends TableSource<RoleTable, Integer> {

}
