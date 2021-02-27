DROP DATABASE IF EXISTS managements;
CREATE DATABASE managements;
Use management;

CREATE TABLE customer (
    id LONG PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50),
    address VARCHAR(50)
);

insert INTO customer(name, email, address) VALUES
('name_1','email_1','address_1'),
('name_2','email_2','address_2'),
('name_3','email_3','address_3'),
('name_4','email_4','address_4'),
('name_5','email_5','address_5'),
('name_6','email_6','address_6'),
('name_7','email_7','address_7'),
('name_8','email_8','address_8'),
('name_9','email_9','address_9');