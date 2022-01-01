package mabubu0203.com.github.cafe.common.source.r2dbc;

import java.time.LocalDateTime;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

@NoRepositoryBean
public interface TableSource<D extends BaseTable, ID> extends ReactiveSortingRepository<D, ID> {

  Mono<D> findByCode(String code);

  default Mono<D> insert(D entity, LocalDateTime localDateTime) {
    entity.setCreatedDateTime(localDateTime);
    entity.setVersion(0);
    entity.setNew(true);
    return this.save(entity);
  }

  default Mono<D> update(D entity, LocalDateTime localDateTime) {
    entity.setUpdatedDateTime(localDateTime);
    entity.setNew(false);
    return this.save(entity);
  }

  default Mono<D> logicalDelete(D entity, LocalDateTime localDateTime) {
    entity.setDeletedDateTime(localDateTime);
    entity.setDeletedFlag(BaseTable.DeletedFlag.is_true);
    entity.setNew(false);
    return this.save(entity);
  }

}
