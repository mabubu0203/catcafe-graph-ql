CREATE TABLE IF NOT EXISTS authentication_user
(
  id                INT UNSIGNED AUTO_INCREMENT  NOT NULL COMMENT 'ユーザーID',
  code              CHAR(36) UNIQUE              NOT NULL COMMENT 'ユーザーコード',
  username          VARCHAR(256) UNIQUE          NOT NULL COMMENT 'Username',
  password          VARCHAR(256)                 NOT NULL COMMENT 'Password',
  memo              VARCHAR(256) COMMENT 'ユーザーメモ',
  created_date_time DATETIME                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
  created_by        INT UNSIGNED                 NOT NULL DEFAULT 0 COMMENT '登録者',
  version           INT UNSIGNED                 NOT NULL DEFAULT 0 COMMENT 'Version',
  updated_date_time DATETIME                              DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  updated_by        INT UNSIGNED                          DEFAULT NULL COMMENT '更新者',
  deleted_date_time DATETIME                              DEFAULT NULL COMMENT '削除日時',
  deleted_flag      ENUM ('is_false', 'is_true') NOT NULL DEFAULT 'is_false' COMMENT '論理削除フラグ:is_false-未削除,is_true-削除済',
  PRIMARY KEY (id)
  ) DEFAULT CHARSET = UTF8MB4 COMMENT 'User';

CREATE TABLE IF NOT EXISTS role
(
  id                INT UNSIGNED AUTO_INCREMENT  NOT NULL COMMENT 'RoleID',
  role_key          VARCHAR(256) UNIQUE          NOT NULL COMMENT 'RoleKey',
  memo              VARCHAR(256) COMMENT 'Roleメモ',
  created_date_time DATETIME                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
  created_by        INT UNSIGNED                 NOT NULL DEFAULT 0 COMMENT '登録者',
  version           INT UNSIGNED                 NOT NULL DEFAULT 0 COMMENT 'Version',
  updated_date_time DATETIME                              DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  updated_by        INT UNSIGNED                          DEFAULT NULL COMMENT '更新者',
  deleted_date_time DATETIME                              DEFAULT NULL COMMENT '削除日時',
  deleted_flag      ENUM ('is_false', 'is_true') NOT NULL DEFAULT 'is_false' COMMENT '論理削除フラグ:is_false-未削除,is_true-削除済',
  PRIMARY KEY (id)
  ) DEFAULT CHARSET = UTF8MB4 COMMENT 'Role';

CREATE TABLE IF NOT EXISTS permission
(
  id                INT UNSIGNED AUTO_INCREMENT  NOT NULL COMMENT 'PermissionID',
  permission_key    VARCHAR(256) UNIQUE          NOT NULL COMMENT 'PermissionKey',
  memo              VARCHAR(256) COMMENT 'Permissionメモ',
  created_date_time DATETIME                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
  created_by        INT UNSIGNED                 NOT NULL DEFAULT 0 COMMENT '登録者',
  version           INT UNSIGNED                 NOT NULL DEFAULT 0 COMMENT 'Version',
  updated_date_time DATETIME                              DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  updated_by        INT UNSIGNED                          DEFAULT NULL COMMENT '更新者',
  deleted_date_time DATETIME                              DEFAULT NULL COMMENT '削除日時',
  deleted_flag      ENUM ('is_false', 'is_true') NOT NULL DEFAULT 'is_false' COMMENT '論理削除フラグ:is_false-未削除,is_true-削除済',
  PRIMARY KEY (id)
  ) DEFAULT CHARSET = UTF8MB4 COMMENT 'Permission';


CREATE TABLE IF NOT EXISTS user_has_role
(
  id                       INT UNSIGNED AUTO_INCREMENT  NOT NULL COMMENT 'ID',
  authentication_user_code VARCHAR(256)                 NOT NULL COMMENT 'ユーザーコード',
  role_key                 VARCHAR(256)                 NOT NULL COMMENT 'RoleKey',
  created_date_time        DATETIME                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
  created_by               INT UNSIGNED                 NOT NULL DEFAULT 0 COMMENT '登録者',
  version                  INT UNSIGNED                 NOT NULL DEFAULT 0 COMMENT 'Version',
  updated_date_time        DATETIME                              DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  updated_by               INT UNSIGNED                          DEFAULT NULL COMMENT '更新者',
  deleted_date_time        DATETIME                              DEFAULT NULL COMMENT '削除日時',
  deleted_flag             ENUM ('is_false', 'is_true') NOT NULL DEFAULT 'is_false' COMMENT '論理削除フラグ:is_false-未削除,is_true-削除済',
  PRIMARY KEY (id),
  UNIQUE (authentication_user_code, role_key)
  ) DEFAULT CHARSET = UTF8MB4 COMMENT 'User_Role 交差';

CREATE TABLE IF NOT EXISTS role_has_permission
(
  id                INT UNSIGNED AUTO_INCREMENT  NOT NULL COMMENT 'ID',
  role_key          VARCHAR(256)                 NOT NULL COMMENT 'RoleKey',
  permission_key    VARCHAR(256)                 NOT NULL COMMENT 'PermissionKey',
  created_date_time DATETIME                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
  created_by        INT UNSIGNED                 NOT NULL DEFAULT 0 COMMENT '登録者',
  version           INT UNSIGNED                 NOT NULL DEFAULT 0 COMMENT 'Version',
  updated_date_time DATETIME                              DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  updated_by        INT UNSIGNED                          DEFAULT NULL COMMENT '更新者',
  deleted_date_time DATETIME                              DEFAULT NULL COMMENT '削除日時',
  deleted_flag      ENUM ('is_false', 'is_true') NOT NULL DEFAULT 'is_false' COMMENT '論理削除フラグ:is_false-未削除,is_true-削除済',
  PRIMARY KEY (id),
  UNIQUE (role_key, permission_key)
  ) DEFAULT CHARSET = UTF8MB4 COMMENT 'Role_Permission 交差';