package mabubu0203.com.github.cafe.api.service.notice;

import mabubu0203.com.github.cafe.api.service.notice.model.input.NoticeRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.notice.model.output.NoticeServiceOutput;
import mabubu0203.com.github.cafe.common.service.WriteApplicationService;

public interface NoticeRegisterService
    extends WriteApplicationService<NoticeRegisterServiceInput, NoticeServiceOutput> {

}
