package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import lombok.Value;

@Value
public class UserAndRole {

  String code;
  String username;
  String password;
  String roleKey;
}
