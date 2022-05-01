package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import java.util.Arrays;
import lombok.Value;
import mabubu0203.com.github.cafe.domain.value.authorization.Permission;
import mabubu0203.com.github.cafe.domain.value.authorization.Role;
import org.springframework.data.relational.core.mapping.Column;

@Value
public class RoleAndPermissions {

  @Column(value = "role_key")
  String roleKey;

  @Column(value = "permission_keys")
  String permissionKeys;

  public Role toRole() {
    var permissions = Arrays.stream(this.permissionKeys.split(","))
        .map(Permission::new)
        .toList();
    return new Role(this.roleKey, permissions);
  }

}
