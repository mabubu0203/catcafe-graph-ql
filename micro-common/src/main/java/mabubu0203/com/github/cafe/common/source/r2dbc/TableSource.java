package mabubu0203.com.github.cafe.common.source.r2dbc;

import java.time.LocalDateTime;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.NoRepositoryBean;
import reactor.core.publisher.Mono;

@NoRepositoryBean
public interface TableSource<D extends BaseTable, ID> extends R2dbcRepository<D, ID> {

  Mono<D> findByCode(String code);

  default Mono<D> insert(D dto, LocalDateTime localDateTime) {
    dto.createdDateTime(localDateTime)
        .version(0)
        .isNew(true);
    return this.save(dto);
  }

  default Mono<D> update(D dto, LocalDateTime localDateTime) {
    dto.updatedDateTime(localDateTime)
        .isNew(false);
    return this.save(dto);
  }

  default Mono<D> logicalDelete(D dto, LocalDateTime localDateTime) {
    dto.deletedDateTime(localDateTime)
        .deletedFlag(BaseTable.DeletedFlag.is_true)
        .isNew(false);
    return this.save(dto);
  }

}
