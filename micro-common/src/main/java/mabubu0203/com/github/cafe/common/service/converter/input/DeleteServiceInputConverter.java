package mabubu0203.com.github.cafe.common.service.converter.input;

import java.util.function.Function;
import mabubu0203.com.github.cafe.common.service.model.ServiceInput;

public interface DeleteServiceInputConverter<I extends ServiceInput, E> extends Function<I, E> {

}
