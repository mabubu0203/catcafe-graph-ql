package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import java.util.ArrayList;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.authorization.Username;
import mabubu0203.com.github.cafe.domain.value.code.UserCode;
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
    return code(entity.getUserCodeValue())
        .username(entity.getUsernameValue())
        .password(entity.password())
        .memo(entity.getMemoValue())
        .version(entity.getVersionValue());
  }

  public AuthenticationUserEntity toEntity() {
    var userCode = new UserCode(super.code());
    var username = new Username(this.username);
    var userMemo = new Memo(this.memo);
    var version = new Version(super.version());
    return AuthenticationUserEntity.builder()
        .userCode(userCode)
        .username(username)
        .password(this.password)
        .roles(new ArrayList<>())
        .memo(userMemo)
        .version(version)
        .build();
  }

}
