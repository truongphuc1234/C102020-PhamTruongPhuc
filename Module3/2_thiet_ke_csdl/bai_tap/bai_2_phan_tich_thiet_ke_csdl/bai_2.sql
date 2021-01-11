DROP DATABASE IF EXISTS sales_management;
CREATE DATABASE sales_management;
USE sales_management;

CREATE TABLE customers (
	customer_number INT PRIMARY KEY,
    customer_name VARCHAR(50) NOT NULL,
    contact_last_name VARCHAR(50) NOT NULL,
    contact_first_name VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    address_line_1 VARCHAR(50) NOT NULL,
    address_line_2 VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    `state` VARCHAR(50) NOT NULL,
    postal_code VARCHAR(15) NOT NULL,
    country VARCHAR(50) NOT NULL,
    credit_limit FLOAT(15),
    sales_rep_employee_number INT NOT NULL,
    FOREIGN KEY(sales_rep_employee_number) REFERENCES employees(employee_number)
);

CREATE TABLE orders (
    order_number INT PRIMARY KEY,
    order_date DATE NOT NULL,
    required_date DATE NOT NULL,
    shipped_date DATE,
    `status` VARCHAR(15) NOT NULL,
    comments TEXT,
    quantity_ordered INT NOT NULL,
    price_each FLOAT(15) NOT NULL,
    customer_number INT NOT NULL,
    FOREIGN KEY(customer_number) REFERENCES customers(customer_number)
);

CREATE TABLE payments (
    customer_number INT NOT NULL,
    check_number VARCHAR(50) NOT NULL,
    payment_date DATE NOT NULL,
    amounts DOUBLE NOT NULL,
    customer_number INT NOT NULL,
    FOREIGN KEY(customer_number) REFERENCES customers(customer_number)
);

CREATE TABLE products (
    product_code VARCHAR(15) PRIMARY KEY,
    product_name VARCHAR(70) NOT NULL,
    product_scale VARCHAR(10) NOT NULL,
    product_vendor VARCHAR(50) NOT NULL,
    product_description TEXT NOT NULL,
    quantity_in_stock INT NOT NULL,
    buy_price FLOAT(15),
    msrp FLOAT(15)
    product_line VARCHAR(50) NOT NULL,
    FOREIGN KEY (product_line) REFERENCES product_lines(product_line)
);

CREATE TABLE product_lines (
    product_line VARCHAR(50) PRIMARY KEY,
    text_description TEXT,
    image BLOB(25000)
);

CREATE TABLE employees (
    employee_number INT PRIMARY KEY,
    last_name VARCHAR(50)NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    job_title(50) NOT NULL,
    report_to INT NOT NULL,
    FOREIGN KEY (report_to) REFERENCES employees(employee_number),
    office_code INT NOT NULL,
    FOREIGN KEY (office_code) REFERENCES offices(office_code)
);

CREATE TABLE offices (
    office_code VARCHAR(10) PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    address_line_1 VARCHAR(50) NOT NULL,
    address_line_2 VARCHAR(50),
    `state` VARCHAR(50),
    country VARCHAR(50) NOT NULL,
    postal_code VARCHAR(15) NOT NULL
);

CREATE TABLE order_details (
    product_code VARCHAR(15) NOT NULL,
    order_number INT NOT NULL,
    PRIMARY KEY(product_code, order_number),
    FOREIGN KEY (product_code) REFERENCES products(product_code),
    FOREIGN KEY (order_number) REFERENCES orders(order_number)
)