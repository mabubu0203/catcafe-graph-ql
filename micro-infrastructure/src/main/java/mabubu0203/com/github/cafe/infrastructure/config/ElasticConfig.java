package mabubu0203.com.github.cafe.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

@Configuration
@EntityScan(
    basePackages = {
        "mabubu0203.com.github.cafe.infrastructure.source.elastic.dto",
    })
@EnableReactiveElasticsearchRepositories(
    basePackages = {
        "mabubu0203.com.github.cafe.infrastructure.source.elastic",
    })
public class ElasticConfig {

}
