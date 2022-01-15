package mabubu0203.com.github.cafe.common.source.elastic;

import java.time.Instant;
import mabubu0203.com.github.cafe.common.source.elastic.base.BaseDocument;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

@NoRepositoryBean
public interface DocumentSource<D extends BaseDocument, ID>
    extends ReactiveSortingRepository<D, ID> {

  Mono<D> findByCode(String code);

  default Mono<D> insert(D dto, Instant createdDate) {
    dto.createdDate(createdDate)
        .version(0)
        .isNew(true);
    return this.save(dto);
  }

  default Mono<D> update(D dto, Instant lastModifiedDate) {
    dto.lastModifiedDate(lastModifiedDate)
        .isNew(false);
    return this.save(dto);
  }

  Mono<Void> deleteByCode(String code);

}
