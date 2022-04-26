package mabubu0203.com.github.cafe.api.service.notice.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.notice.NoticeDeleteService;
import mabubu0203.com.github.cafe.api.service.notice.impl.converter.input.NoticeDeleteServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.notice.impl.converter.output.NoticeDeleteServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeDeleteServiceInput;
import mabubu0203.com.github.cafe.api.service.notice.model.output.NoticeDeleteServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.notice.NoticeRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NoticeDeleteServiceImpl implements NoticeDeleteService {

  private final NoticeRepository noticeRepository;

  @Override
  @PreAuthorize("hasPermission(#input,'NoticeDeleteServiceInput','Delete')")
  @Transactional
  public Mono<NoticeDeleteServiceOutput> action(NoticeDeleteServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Mono.just(input)
        .map(new NoticeDeleteServiceInputConverter())
        .flatMap(entity -> this.noticeRepository.logicalDelete(entity, receptionTime))
        .map(new NoticeDeleteServiceOutputConverter());
  }

  @Override
  public Mono<NoticeDeleteServiceOutput> onAfterSave(NoticeDeleteServiceOutput output) {
    return null;
  }

}
