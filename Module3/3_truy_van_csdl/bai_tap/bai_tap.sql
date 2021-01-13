drop database if EXISTS library;
create database library;

use library;

CREATE TABLE category (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(30)
);

CREATE TABLE book (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    category_id INT,
    book_name VARCHAR(50),
    author VARCHAR(50),
    FOREIGN KEY (category_id)
        REFERENCES category (category_id)
);

CREATE TABLE student (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(50),
    address VARCHAR(100),
    email VARCHAR(50),
    image BLOB(25600)
);

CREATE TABLE borrow_orders (
    student_id INT NOT NULL,
    book_id INT NOT NULL,
    PRIMARY KEY (student_id , book_id),
    FOREIGN KEY (student_id)
        REFERENCES student (student_id),
    FOREIGN KEY (book_id)
        REFERENCES book (book_id)
);
