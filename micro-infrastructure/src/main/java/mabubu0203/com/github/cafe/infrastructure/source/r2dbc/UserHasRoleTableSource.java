package mabubu0203.com.github.cafe.infrastructure.source.r2dbc;

import java.time.LocalDateTime;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.UserHasRoleTable;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserHasRoleTableSource extends R2dbcRepository<UserHasRoleTable, Integer> {

  default Mono<UserHasRoleTable> insert(UserHasRoleTable dto, LocalDateTime localDateTime) {
    dto.createdDateTime(localDateTime)
        .version(0)
        .isNew(true);
    return this.save(dto);
  }

  default Mono<UserHasRoleTable> update(UserHasRoleTable dto, LocalDateTime localDateTime) {
    dto.updatedDateTime(localDateTime)
        .isNew(false);
    return this.save(dto);
  }

  default Mono<UserHasRoleTable> logicalDelete(UserHasRoleTable dto, LocalDateTime localDateTime) {
    dto.deletedDateTime(localDateTime)
        .deletedFlag(BaseTable.DeletedFlag.is_true)
        .isNew(false);
    return this.save(dto);
  }

}
