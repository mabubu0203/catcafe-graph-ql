package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import lombok.Value;

@Value
public class RoleAndPermissions {
  String roleKey;
  String permissionKeys;
}
