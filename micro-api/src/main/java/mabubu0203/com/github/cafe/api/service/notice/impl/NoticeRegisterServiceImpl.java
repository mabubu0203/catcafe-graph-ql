package mabubu0203.com.github.cafe.api.service.notice.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.notice.NoticeRegisterService;
import mabubu0203.com.github.cafe.api.service.notice.impl.converter.input.NoticeRegisterServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.notice.impl.converter.output.NoticeServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.notice.model.output.NoticeServiceOutput;
import mabubu0203.com.github.cafe.domain.entity.notice.NoticeEntity;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import mabubu0203.com.github.cafe.domain.repository.notice.NoticeRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NoticeRegisterServiceImpl implements NoticeRegisterService {

  private final LocationRepository locationRepository;
  private final NoticeRepository noticeRepository;

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @Transactional
  public Mono<NoticeServiceOutput> action(NoticeRegisterServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Mono.just(input)
        .map(new NoticeRegisterServiceInputConverter())
        .flatMap(this::beforeRegistration)
        .flatMap(entity -> this.noticeRepository.register(entity, receptionTime))
        .flatMap(this.noticeRepository::findByCode)
        .map(new NoticeServiceOutputConverter());
  }

  @Override
  public Mono<NoticeServiceOutput> onAfterSave(NoticeServiceOutput output) {
    return null;
  }

  private Mono<NoticeEntity> beforeRegistration(NoticeEntity entity) {
    var locationCode = entity.locationCode();
    if (locationCode.isEmpty()) {
      return Mono.just(entity);
    }
    return this.locationRepository.findByCode(locationCode)
        .doOnError(Mono::error)
        .thenReturn(entity);

  }

}
