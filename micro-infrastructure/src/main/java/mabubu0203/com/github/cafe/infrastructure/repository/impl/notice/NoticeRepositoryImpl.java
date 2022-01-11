package mabubu0203.com.github.cafe.infrastructure.repository.impl.notice;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Predicate;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.common.exception.ResourceNotFoundException;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import mabubu0203.com.github.cafe.domain.entity.notice.NoticeEntity;
import mabubu0203.com.github.cafe.domain.entity.notice.NoticeSearchConditions;
import mabubu0203.com.github.cafe.domain.repository.notice.NoticeRepository;
import mabubu0203.com.github.cafe.domain.value.code.NoticeCode;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.NoticeTableSource;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.NoticeTable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class NoticeRepositoryImpl implements NoticeRepository {

  private final NoticeTableSource noticeTableSource;

  @Override
  public Flux<NoticeEntity> search(NoticeSearchConditions searchConditions) {

    Predicate<NoticeTable> isExists = BaseTable::isExists;
    Predicate<NoticeTable> noticeCodeInclude = notice -> {
      var noticeCodes = searchConditions.noticeCodes();
      return noticeCodes.size() == 0 || noticeCodes.contains(notice.code());
    };
    Predicate<NoticeTable> locationCodeInclude = notice -> {
      var locationCodes = searchConditions.locationCodes();
      return locationCodes.size() == 0 || locationCodes.contains(notice.locationCode());
    };

    return this.noticeTableSource.findAll()
        .filter(isExists.and(noticeCodeInclude).and(locationCodeInclude))
        .map(NoticeTable::toEntity);
  }

  @Override
  public Mono<NoticeEntity> findByCode(NoticeCode noticeCode) {
    return this.findDto(noticeCode)
        .map(NoticeTable::toEntity);
  }

  @Override
  public Mono<NoticeCode> register(NoticeEntity entity, LocalDateTime receptionTime) {
    return Mono.just(entity)
        .map(this::attach)
        .map(dto -> dto.createdBy(0))
        .flatMap(dto -> this.noticeTableSource.insert(dto, receptionTime))
        .map(NoticeTable::code)
        .map(NoticeCode::new);
  }

  @Override
  public Mono<NoticeCode> modify(NoticeEntity entity, LocalDateTime receptionTime) {
    return this.findDto(entity.noticeCode())
        .map(dto -> this.attach(dto, entity))
        .map(dto -> dto.updatedBy(0))
        .flatMap(dto -> this.noticeTableSource.update(dto, receptionTime))
        .map(NoticeTable::code)
        .map(NoticeCode::new);
  }

  @Override
  public Mono<NoticeCode> logicalDelete(NoticeEntity entity, LocalDateTime receptionTime) {
    return this.findDto(entity.noticeCode())
        .map(dto -> dto.version(entity.getVersionValue()))
        .flatMap(dto -> this.noticeTableSource.logicalDelete(dto, receptionTime))
        .map(NoticeTable::code)
        .map(NoticeCode::new);
  }

  private Mono<NoticeTable> findDto(NoticeCode noticeCode) {
    return this.noticeTableSource.findByCode(noticeCode.value())
        .filter(BaseTable::isExists)
        // 404で返却するためのエラーを検討
        .switchIfEmpty(Mono.error(new ResourceNotFoundException("お知らせが存在しません")));
  }

  private NoticeTable attach(NoticeEntity entity) {
    return this.attach(null, entity);
  }

  private NoticeTable attach(NoticeTable dto, NoticeEntity entity) {
    return Optional.ofNullable(dto)
        .orElse(new NoticeTable())
        .attach(entity);
  }

}
