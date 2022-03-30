package mabubu0203.com.github.cafe.infrastructure;

import mabubu0203.com.github.cafe.infrastructure.config.ElasticConfig;
import mabubu0203.com.github.cafe.infrastructure.config.R2dbcConfig;
import mabubu0203.com.github.cafe.infrastructure.config.RedisConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ElasticConfig.class),
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = R2dbcConfig.class),
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = RedisConfig.class),
})
public class InfrastructureCore {

}
