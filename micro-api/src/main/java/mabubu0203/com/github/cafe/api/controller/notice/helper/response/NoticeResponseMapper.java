package mabubu0203.com.github.cafe.api.controller.notice.helper.response;

import com.netflix.dgs.codegen.types.Location;
import com.netflix.dgs.codegen.types.Notice;
import mabubu0203.com.github.cafe.api.service.notice.model.output.NoticeServiceOutput;
import mabubu0203.com.github.cafe.common.controller.helper.response.ResponseMapper;

public class NoticeResponseMapper
    implements ResponseMapper<NoticeServiceOutput, Notice> {

  @Override
  public Notice apply(NoticeServiceOutput output) {
    // Locationは LocationQueryController.location(Notice notice) で生成する
    var location = new Location.Builder()
        .code(output.locationCode())
        .build();
    return new Notice.Builder()
        .code(output.noticeCode())
        .location(location)
        .summary(output.summary())
        .detail(output.detail())
        .publicationStartDateTime(null)
        .publicationEndDateTime(null)
        .version(output.version())
        .build();
  }

}
