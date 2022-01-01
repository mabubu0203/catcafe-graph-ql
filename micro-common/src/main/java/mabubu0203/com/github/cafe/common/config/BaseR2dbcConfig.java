package mabubu0203.com.github.cafe.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(
    basePackages = {
        "mabubu0203.com.github.cafe.common.source.r2dbc",
    })
public abstract class BaseR2dbcConfig {

}
