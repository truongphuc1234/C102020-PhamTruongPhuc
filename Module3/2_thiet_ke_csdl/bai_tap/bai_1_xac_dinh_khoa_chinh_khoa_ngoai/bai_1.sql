DROP DATABASE IF EXISTS bank;
CREATE DATABASE bank;
USE bank;

CREATE TABLE customers (
	customer_number INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(50),
    address VARCHAR(50)
);

CREATE TABLE emails (
	email VARCHAR(50) PRIMARY KEY,
    customer_number INT NOT NULL,
    FOREIGN KEY (customer_number) REFERENCES customers(customer_number)
);

CREATE TABLE phones (
	phone VARCHAR(50) PRIMARY KEY,
    customer_number INT NOT NULL,
    FOREIGN KEY (customer_number) REFERENCES customers(customer_number)
);

CREATE TABLE accounts(
	account_number INT PRIMARY KEY,
    account_type ENUM('vip','thuong','doanh nghiep'),
    `date` DATE,
    balance INT,
    customer_number INT,
    FOREIGN KEY(customer_number) REFERENCES customers(customer_number)
);

CREATE TABLE transactions (
	trans_number INT PRIMARY KEY,
    accont_number INT,
    `date` DATE,
    amounts INT,
    `description` VARCHAR(100),
    FOREIGN KEY(account_number) REFERENCES accounts(account_number)
);
    
