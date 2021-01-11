DROP DATABASE IF EXISTS example;
CREATE DATABASE example;
USE example;

CREATE TABLE contacts (
contact_id INT NOT NULL AUTO_INCREMENT,
last_name VARCHAR(30) NOT NULL,
first_name VARCHAR(25),
birthday DATE,
CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);

CREATE TABLE suppliers (
supplier_id INT NOT NULL AUTO_INCREMENT,
supplier_name VARCHAR(50) NOT NULL,
acount_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);

ALTER TABLE contacts 
DROP COLUMN last_name,
ADD last_name VARCHAR(40) NOT NULL
AFTER contact_id;

ALTER TABLE contacts
MODIFY last_name VARCHAR(50) NULL;

ALTER TABLE contacts
CHANGE last_name lastname VARCHAR(49) NULL;

ALTER TABLE contacts
RENAME TO people;