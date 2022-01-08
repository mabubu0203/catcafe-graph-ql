package mabubu0203.com.github.cafe.infrastructure.source.r2dbc;

import mabubu0203.com.github.cafe.common.source.r2dbc.TableSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.NoticeTable;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeSource extends TableSource<NoticeTable, Integer> {

}
