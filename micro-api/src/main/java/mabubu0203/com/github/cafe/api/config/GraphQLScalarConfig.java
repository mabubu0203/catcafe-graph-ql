package mabubu0203.com.github.cafe.api.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLScalarConfig implements RuntimeWiringConfigurer {

  @Override
  public void configure(RuntimeWiring.Builder builder) {
    builder
        .scalar(ExtendedScalars.Date)
        .scalar(ExtendedScalars.DateTime);
  }

}
