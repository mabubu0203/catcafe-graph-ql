package mabubu0203.com.github.cafe.api.controller.cast;

import com.netflix.dgs.codegen.types.Cast;
import com.netflix.dgs.codegen.types.CastCat;
import com.netflix.dgs.codegen.types.CastCatCommand;
import com.netflix.dgs.codegen.types.CastCommand;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CastCommandController {

  @MutationMapping
  public Cast castCreate(
      @Argument("input") CastCommand input
  ) {
    return
        Cast.newBuilder()
            .id(0)
            .build();
  }

  @MutationMapping
  public Cast castUpdate(
      @Argument("id") Integer id,
      @Argument("input") CastCommand input,
      @Argument("version") Integer version
  ) {
    return
        Cast.newBuilder()
            .id(id)
            .build();
  }

  @MutationMapping
  public Integer castDelete(
      @Argument("id") Integer id,
      @Argument("version") Integer version
  ) {
    return 1;
  }

  @MutationMapping
  public CastCat castCatCreate(
      @Argument("input") CastCatCommand input
  ) {
    return
        CastCat.newBuilder()
            .id(0)
            .build();
  }

  @MutationMapping
  public CastCat castCatUpdate(
      @Argument("id") Integer id,
      @Argument("input") CastCatCommand input,
      @Argument("version") Integer version
  ) {
    return
        CastCat.newBuilder()
            .id(id)
            .build();
  }

  @MutationMapping
  public Integer castCatDelete(
      @Argument("id") Integer id,
      @Argument("version") Integer version
  ) {
    return 2;
  }
}
