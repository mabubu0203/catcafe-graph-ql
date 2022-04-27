package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import lombok.Value;
import org.springframework.data.relational.core.mapping.Column;

@Value
public class RoleAndPermissions {

  @Column(value = "role_key")
  String roleKey;

  @Column(value = "permission_keys")
  String permissionKeys;
}
