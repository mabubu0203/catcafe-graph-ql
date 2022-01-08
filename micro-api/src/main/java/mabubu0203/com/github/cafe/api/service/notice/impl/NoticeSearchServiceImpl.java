package mabubu0203.com.github.cafe.api.service.notice.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.notice.NoticeSearchService;
import mabubu0203.com.github.cafe.api.service.notice.impl.converter.input.NoticeSearchServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.notice.impl.converter.output.NoticeServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeSearchServiceInput;
import mabubu0203.com.github.cafe.api.service.notice.model.output.NoticeServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.notice.NoticeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class NoticeSearchServiceImpl implements NoticeSearchService {

  private final NoticeRepository noticeRepository;

  @Override
  @Transactional(readOnly = true)
  public Flux<NoticeServiceOutput> action(NoticeSearchServiceInput input) {
    return Flux.just(input)
        .map(new NoticeSearchServiceInputConverter())
        .flatMap(this.noticeRepository::search)
        .map(new NoticeServiceOutputConverter());
  }

}
