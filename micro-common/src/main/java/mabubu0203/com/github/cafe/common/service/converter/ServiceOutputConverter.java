package mabubu0203.com.github.cafe.common.service.converter;

import java.util.function.Function;
import mabubu0203.com.github.cafe.common.service.model.ServiceOutput;

public interface ServiceOutputConverter<I, O extends ServiceOutput> extends Function<I, O> {

}
