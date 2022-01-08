package mabubu0203.com.github.cafe.api.controller.notice;

import com.netflix.dgs.codegen.types.Notice;
import com.netflix.dgs.codegen.types.NoticeCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.controller.notice.helper.request.NoticeCreateRequestMapper;
import mabubu0203.com.github.cafe.api.controller.notice.helper.response.NoticeResponseMapper;
import mabubu0203.com.github.cafe.api.service.notice.NoticeRegisterService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class NoticeCommandController {

  private final NoticeRegisterService noticeRegisterService;

  @MutationMapping(name = "noticeCreate")
  public Mono<Notice> noticeCreate(
      @Argument("input") NoticeCommand input
  ) {
    return Mono.just(input)
        .map(new NoticeCreateRequestMapper())
        .flatMap(this.noticeRegisterService::action)
        .map(new NoticeResponseMapper());
  }

}
