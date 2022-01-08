package mabubu0203.com.github.cafe.common.controller.helper.request;

import java.util.function.Supplier;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

public interface ReadRequestMapper<I extends ServiceInput>
    extends Supplier<I> {

}
