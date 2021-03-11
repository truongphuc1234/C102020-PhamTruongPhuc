DROP
DATABASE IF EXISTS login;
CREATE
DATABASE login;
USE
login;

CREATE TABLE app_user
(
    user_id          BIGINT       NOT NULL PRIMARY KEY,
    user_name        VARCHAR(36)  NOT NULL UNIQUE,
    encrypt_password VARCHAR(128) NOT NULL,
    enabled          BIT          NOT NULL
);

CREATE TABLE app_role
(
    role_id   BIGINT      NOT NULL PRIMARY KEY,
    role_name VARCHAR(30) NOT NULL UNIQUE,
);

CREATE TABLE user_role
(
    id      BIGINT NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    UNIQUE (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES app_user (user_id),
    FOREIGN KEY (role_id) REFERENCES app_role (role_id)
);

CREATE TABLE persistent_logins
(
    username  VARCHAR(64) NOT NULL,
    series    VARCHAR(64) NOT NULL PRIMARY KEY,
    token     VARCHAR(64) NOT NULL,
    last_used TIMESTAMP   NOT NULL,
);

INSERT INTO app_user (user_id, user_name, encrypt_password, enabled)
VALUES (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

INSERT INTO app_user (user_id, user_name, encrypt_password, enabled)
VALUES (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

INSERT INTO app_role (ROLE_ID, ROLE_NAME)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO app_role (ROLE_ID, ROLE_NAME)
VALUES (2, 'ROLE_USER');

INSERT INTO user_role (ID, USER_ID, ROLE_ID)
VALUES (1, 1, 1);
INSERT INTO user_role (ID, USER_ID, ROLE_ID)
VALUES (2, 1, 2);
INSERT INTO user_role (ID, USER_ID, ROLE_ID)
VALUES (3, 2, 2);