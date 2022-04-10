package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Accessors(fluent = true)
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(value = "role")
public class RoleTable extends BaseTable<Integer> {

  @Id
  @Column(value = "id")
  private Integer id;

  @Override
  public Integer getId() {
    return this.id;
  }

  @Override
  @Transient
  public boolean isNew() {
    return super.isNew() || Objects.isNull(this.id);
  }

  @Override
  @Transient
  public RoleTable createdBy(Integer createdBy) {
    super.createdBy(createdBy);
    return this;
  }

  @Override
  @Transient
  public RoleTable version(Integer version) {
    super.version(version);
    return this;
  }

  @Override
  @Transient
  public RoleTable updatedBy(Integer updatedBy) {
    super.updatedBy(updatedBy);
    return this;
  }
}
