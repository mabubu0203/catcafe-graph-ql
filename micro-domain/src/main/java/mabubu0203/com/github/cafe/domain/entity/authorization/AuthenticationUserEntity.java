package mabubu0203.com.github.cafe.domain.entity.authorization;

import java.util.List;
import java.util.Optional;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.Version;
import mabubu0203.com.github.cafe.domain.value.authorization.Role;
import mabubu0203.com.github.cafe.domain.value.authorization.Username;
import mabubu0203.com.github.cafe.domain.value.code.UserCode;

/**
 * 認証済みユーザー
 */
@Accessors(fluent = true)
@Builder
@Value
@With
public class AuthenticationUserEntity {

  UserCode userCode;
  Username username;
  String password;
  List<Role> roles;
  Memo memo;
  Version version;

  public String getUserCodeValue() {
    return Optional.ofNullable(this.userCode)
        .map(UserCode::value)
        .orElse(null);
  }

  public String getUsernameValue() {
    return Optional.ofNullable(this.username)
        .map(Username::value)
        .orElse(null);
  }

  public String getMemoValue() {
    return Optional.ofNullable(this.memo)
        .map(Memo::value)
        .orElse(null);
  }

  public Integer getVersionValue() {
    return Optional.ofNullable(this.version)
        .map(Version::value)
        .orElse(null);
  }

  public boolean addRole(Role role) {
    return this.roles.add(role);
  }

}
