package mabubu0203.com.github.cafe.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EntityScan(
    basePackages = {
        "mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto",
    })
@EnableR2dbcRepositories(
    basePackages = {
        "mabubu0203.com.github.cafe.infrastructure.source.r2dbc",
    })
public class R2dbcConfig {

}
