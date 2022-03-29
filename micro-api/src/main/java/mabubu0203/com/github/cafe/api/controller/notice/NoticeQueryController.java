package mabubu0203.com.github.cafe.api.controller.notice;

import com.netflix.dgs.codegen.types.Notice;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.controller.notice.helper.request.NoticeSearchRequestMapper;
import mabubu0203.com.github.cafe.api.controller.notice.helper.response.NoticeResponseMapper;
import mabubu0203.com.github.cafe.api.service.notice.NoticeSearchService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class NoticeQueryController {

  private final NoticeSearchService noticeSearchService;

  @QueryMapping(name = "noticeSearch")
  public Flux<Notice> noticeSearch(
      @Argument("codes") List<String> codes,
      @Argument("locationCodes") List<String> locationCodes
  ) {
    return Mono.just(new NoticeSearchRequestMapper(codes, locationCodes))
        .map(NoticeSearchRequestMapper::get)
        .flatMapMany(this.noticeSearchService::action)
        .map(new NoticeResponseMapper());
  }

}
