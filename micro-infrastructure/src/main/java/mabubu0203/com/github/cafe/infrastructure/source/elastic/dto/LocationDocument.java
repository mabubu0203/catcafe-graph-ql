package mabubu0203.com.github.cafe.infrastructure.source.elastic.dto;

import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.source.elastic.base.BaseDocument;
import mabubu0203.com.github.cafe.domain.entity.location.LocationEntity;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Accessors(fluent = true)
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Document(indexName = "location")
public class LocationDocument extends BaseDocument<String> {

  @Id
  private String id;

  @Field(type = FieldType.Text)
  private String name;

  @Field(type = FieldType.Text)
  private String memo;

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  @Transient
  public boolean isNew() {
    return super.isNew() || Objects.isNull(this.id);
  }

  @Override
  @Transient
  public LocationDocument code(String code) {
    super.code(code);
    return this;
  }

  @Override
  @Transient
  public LocationDocument version(Integer version) {
    super.version(version);
    return this;
  }

  public LocationDocument attach(LocationEntity entity) {
    return code(entity.getLocationCodeValue())
        .name(entity.name())
        .memo(entity.getMemoValue())
        .version(entity.getVersionValue());
  }

  public LocationEntity toEntity() {
    var locationCode = new LocationCode(super.code());
    var locationMemo = new Memo(this.memo);
    var version = new Version(super.version());
    return LocationEntity.builder()
        .locationCode(locationCode)
        .name(this.name)
        .memo(locationMemo)
        .version(version)
        .build();
  }

}
