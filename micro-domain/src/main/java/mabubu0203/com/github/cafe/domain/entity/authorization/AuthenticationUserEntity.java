package mabubu0203.com.github.cafe.domain.entity.authorization;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
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

  public AuthenticationUserEntity(String username, String password) {
    this.username = new Username(username);
    this.password = password;
    this.roles = new ArrayList<>();
  }

  public boolean addRole(Role role) {
    return this.roles.add(role);
  }

}
