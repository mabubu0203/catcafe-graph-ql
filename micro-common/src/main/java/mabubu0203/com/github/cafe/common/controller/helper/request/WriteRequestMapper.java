package mabubu0203.com.github.cafe.common.controller.helper.request;

import java.util.function.Function;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

public interface WriteRequestMapper<R, I extends ServiceInput>
    extends Function<R, I> {

}
