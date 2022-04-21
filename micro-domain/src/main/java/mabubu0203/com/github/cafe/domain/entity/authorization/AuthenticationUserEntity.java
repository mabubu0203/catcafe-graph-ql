package mabubu0203.com.github.cafe.domain.entity.authorization;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.With;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.domain.value.authorization.Role;
import mabubu0203.com.github.cafe.domain.value.authorization.Username;

/**
 * 認証済みユーザー
 */
@Accessors(fluent = true)
@Data
public class AuthenticationUserEntity {

  Username username;
  String password;
  List<Role> roles;

  public boolean addRole(Role role) {
    return this.roles.add(role);
  }

}
