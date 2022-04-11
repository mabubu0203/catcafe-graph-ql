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
@Table(value = "user_has_role")
public class UserHasRoleTable extends BaseTable<Integer> {

  @Id
  @Column(value = "id")
  private Integer id;

  @Column(value = "authentication_user_code")
  private String authenticationUserCode;

  @Column(value = "role_key")
  private String roleKey;

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
  public UserHasRoleTable createdBy(Integer createdBy) {
    super.createdBy(createdBy);
    return this;
  }

  @Override
  @Transient
  public UserHasRoleTable version(Integer version) {
    super.version(version);
    return this;
  }

  @Override
  @Transient
  public UserHasRoleTable updatedBy(Integer updatedBy) {
    super.updatedBy(updatedBy);
    return this;
  }

}
