package mabubu0203.com.github.cafe.common.service.converter.output;

import java.util.function.Function;
import mabubu0203.com.github.cafe.common.service.model.ServiceOutput;

public interface ModifyServiceOutputConverter<I, O extends ServiceOutput> extends Function<I, O> {

}
