package mabubu0203.com.github.cafe.common.controller.helper.response;

import java.util.function.Function;
import mabubu0203.com.github.cafe.common.service.model.ServiceOutput;

public interface SearchResponseMapper<O extends ServiceOutput, R> extends Function<O, R> {

}
