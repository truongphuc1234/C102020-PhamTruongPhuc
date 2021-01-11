DROP DATABASE IF EXISTS example;
CREATE DATABASE example;
USE example;

CREATE TABLE users(
	user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(40),
    `password` VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE roles(
	role_id INT AUTO_INCREMENT,
    role_name VARCHAR(50),
    PRIMARY KEY(role_id)
);

CREATE TABLE user_roles (
	user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY(user_id) REFERENCES users (user_id),
    FOREIGN KEY(role_id) REFERENCES roles (role_id)
);


    
    