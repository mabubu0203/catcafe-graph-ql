package mabubu0203.com.github.cafe.common.source.elastic.base;

import java.time.Instant;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Accessors(fluent = true)
@Data
public abstract class BaseDocument<ID> implements Persistable<ID> {

  @Field(name = "code", type = FieldType.Text)
  private String code;

  @CreatedDate
  @Field(name = "created_date",
      type = FieldType.Date, format = DateFormat.basic_date)
  private Instant createdDate;

  @Field(name = "version", type = FieldType.Integer)
  private Integer version;

  @LastModifiedDate
  @Field(name = "last_modified_date",
      type = FieldType.Date, format = DateFormat.basic_date)
  private Instant lastModifiedDate;

  @Transient
  private boolean isNew;

}
