CREATE TABLE IF NOT EXISTS cast
(
  id                    INT UNSIGNED AUTO_INCREMENT  NOT NULL COMMENT 'キャストID',
  code                  VARCHAR(256)                 NOT NULL COMMENT 'キャストコード',
  location_code         VARCHAR(256)                 NOT NULL COMMENT '所在地コード',
  cast_cat_code         VARCHAR(256)                 NOT NULL COMMENT 'キャスト(猫)コード',
  employment_status     ENUM ('main', 'sub')         NOT NULL DEFAULT 'main' COMMENT '雇用ステータス:main,sub',
  first_attendance_date DATE COMMENT '初出勤日',
  last_attendance_date  DATE COMMENT '最終出勤日',
  memo                  VARCHAR(256) COMMENT '店舗メモ',
  created_date_time     DATETIME                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
  created_by            INT UNSIGNED                 NOT NULL DEFAULT 0 COMMENT '登録者',
  version               INT UNSIGNED                 NOT NULL DEFAULT 0 COMMENT 'Version',
  updated_date_time     DATETIME                              DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  updated_by            INT UNSIGNED                          DEFAULT NULL COMMENT '更新者',
  deleted_date_time     DATETIME                              DEFAULT NULL COMMENT '削除日時',
  deleted_flag          ENUM ('is_false', 'is_true') NOT NULL DEFAULT 'is_false' COMMENT '論理削除フラグ:is_false-未削除,is_true-削除済',
  PRIMARY KEY (id)
) DEFAULT CHARSET = UTF8MB4 COMMENT 'キャスト';

CREATE TABLE IF NOT EXISTS cast_cat
(
  id                INT UNSIGNED AUTO_INCREMENT        NOT NULL COMMENT 'キャスト(猫)ID',
  code              VARCHAR(256)                       NOT NULL COMMENT 'キャスト(猫)コード',
  name              VARCHAR(256)                       NOT NULL COMMENT 'キャスト(猫)名',
  image_url         VARCHAR(256)                                DEFAULT NULL COMMENT '画像URL',
  type              VARCHAR(256) COMMENT '猫種',
  sex               ENUM ('unknown', 'male', 'female') NOT NULL DEFAULT 'unknown' COMMENT '性別:unknown,male,female',
  birthday_date     DATE COMMENT '誕生日',
  favorite          VARCHAR(256)                                DEFAULT NULL COMMENT '好きなこと',
  dislike           VARCHAR(256)                                DEFAULT NULL COMMENT '嫌いなこと',
  prohibition       VARCHAR(256)                                DEFAULT NULL COMMENT '禁止事項',
  brothers          JSON COMMENT '兄弟',
  sisters           JSON COMMENT '姉妹',
  memo              VARCHAR(256) COMMENT 'キャスト(猫)メモ',
  created_date_time DATETIME                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
  created_by        INT UNSIGNED                       NOT NULL DEFAULT 0 COMMENT '登録者',
  version           INT UNSIGNED                       NOT NULL DEFAULT 0 COMMENT 'Version',
  updated_date_time DATETIME                                    DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  updated_by        INT UNSIGNED                                DEFAULT NULL COMMENT '更新者',
  deleted_date_time DATETIME                                    DEFAULT NULL COMMENT '削除日時',
  deleted_flag      ENUM ('is_false', 'is_true')       NOT NULL DEFAULT 'is_false' COMMENT '論理削除フラグ:is_false-未削除,is_true-削除済',
  PRIMARY KEY (id)
) DEFAULT CHARSET = UTF8MB4 COMMENT 'キャスト(猫)';