package mabubu0203.com.github.cafe.infrastructure.source.r2dbc;

import mabubu0203.com.github.cafe.common.source.r2dbc.TableSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.CastTable;
import org.springframework.stereotype.Repository;

@Repository
public interface CastSource extends TableSource<CastTable, Integer> {

}
