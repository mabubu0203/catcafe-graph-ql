package mabubu0203.com.github.cafe.api.controller.notice;

import com.netflix.dgs.codegen.types.Notice;
import com.netflix.dgs.codegen.types.NoticeCommand;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.controller.notice.helper.request.NoticeCreateRequestMapper;
import mabubu0203.com.github.cafe.api.controller.notice.helper.request.NoticeDeleteRequestMapper;
import mabubu0203.com.github.cafe.api.controller.notice.helper.request.NoticeUpdateRequestMapper;
import mabubu0203.com.github.cafe.api.controller.notice.helper.response.NoticeDeleteResponseMapper;
import mabubu0203.com.github.cafe.api.controller.notice.helper.response.NoticeResponseMapper;
import mabubu0203.com.github.cafe.api.service.notice.NoticeDeleteService;
import mabubu0203.com.github.cafe.api.service.notice.NoticeModifyService;
import mabubu0203.com.github.cafe.api.service.notice.NoticeRegisterService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class NoticeCommandController {

  private final NoticeRegisterService noticeRegisterService;
  private final NoticeModifyService noticeModifyService;
  private final NoticeDeleteService noticeDeleteService;

  @MutationMapping(name = "noticeCreate")
  public Mono<Notice> noticeCreate(
      @Argument("input") NoticeCommand input
  ) {
    return Mono.just(input)
        .map(new NoticeCreateRequestMapper())
        .flatMap(this.noticeRegisterService::action)
        .map(new NoticeResponseMapper());
  }

  @MutationMapping(name = "noticeUpdate")
  public Mono<Notice> noticeUpdate(
      @Argument("code") String code,
      @Argument("input") NoticeCommand input,
      @Argument("version") Integer version
  ) {
    return Mono.just(input)
        .map(new NoticeUpdateRequestMapper(code, version))
        .flatMap(this.noticeModifyService::action)
        .map(new NoticeResponseMapper());
  }

  @MutationMapping(name = "noticeDelete")
  public Mono<String> noticeDelete(
      @Argument("code") String code,
      @Argument("version") Integer version
  ) {
    return Mono.just(code)
        .map(new NoticeDeleteRequestMapper(version))
        .flatMap(this.noticeDeleteService::action)
        .map(new NoticeDeleteResponseMapper());
  }

}
