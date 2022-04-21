INSERT INTO `role`(`role_key`)
VALUES ('Admin');

INSERT INTO `role`(`role_key`)
VALUES ('Web');

INSERT INTO `permission`(`permission_key`)
VALUES ('Search');
INSERT INTO `permission`(`permission_key`)
VALUES ('Register');
INSERT INTO `permission`(`permission_key`)
VALUES ('Modify');
INSERT INTO `permission`(`permission_key`)
VALUES ('Delete');

INSERT INTO `role_has_permission`(`role_key`, `permission_key`)
VALUES ('Admin', 'Search');
INSERT INTO `role_has_permission`(`role_key`, `permission_key`)
VALUES ('Admin', 'Register');
INSERT INTO `role_has_permission`(`role_key`, `permission_key`)
VALUES ('Admin', 'Modify');
INSERT INTO `role_has_permission`(`role_key`, `permission_key`)
VALUES ('Admin', 'Delete');


