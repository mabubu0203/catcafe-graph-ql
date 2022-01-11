package mabubu0203.com.github.cafe.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

@Configuration

@EnableReactiveElasticsearchRepositories(
    basePackages = {
        "mabubu0203.com.github.cafe.common.source.elastic",
    })
public abstract class BaseElasticConfig {

}
