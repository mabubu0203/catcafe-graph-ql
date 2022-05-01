package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Accessors(fluent = true)
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(value = "authentication_user")
public class AuthenticationUserTable extends BaseTable<Integer> {

  @Id
  @Column(value = "id")
  private Integer id;

  @Column(value = "username")
  private String username;

  @Column(value = "password")
  private String password;

  @Column(value = "memo")
  private String memo;

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
  public AuthenticationUserTable code(String code) {
    super.code(code);
    return this;
  }

  @Override
  @Transient
  public AuthenticationUserTable createdBy(Integer createdBy) {
    super.createdBy(createdBy);
    return this;
  }

  @Override
  @Transient
  public AuthenticationUserTable version(Integer version) {
    super.version(version);
    return this;
  }

  @Override
  @Transient
  public AuthenticationUserTable updatedBy(Integer updatedBy) {
    super.updatedBy(updatedBy);
    return this;
  }

  public AuthenticationUserTable attach(AuthenticationUserEntity entity) {
    return code(null)
        .username(entity.username().value())
        .password(entity.password())
        .memo(null)
        .version(null);
  }

}
