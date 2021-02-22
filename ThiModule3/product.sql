drop database if exists management;
create database management;
use management;

CREATE TABLE product (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(45) NOT NULL,
    product_price INT NOT NULL,
    discount INT NOT NULL,
    stock INT NOT NULL
);

CREATE TABLE employee (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(45) NOT NULL,
    employee_birthday DATE NOT NULL,
    employee_address VARCHAR(45) NOT NULL
);

CREATE TABLE customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(45) NOT NULL,
    customer_birthday DATE NOT NULL,
    customer_address VARCHAR(45) NOT NULL,
    customer_email VARCHAR(45) NOT NULL
);
CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    order_payment_method VARCHAR(45) NOT NULL,
    customer_id INT NOT NULL,
    employee_id INT NOT NULL,
    order_date DATE NOT NULL,
    delivery_date DATE,
    delivery_address VARCHAR(45),
    FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id),
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id)
);

CREATE TABLE order_product (
    product_id INT,
    order_id INT,
    quantity INT NOT NULL,
    FOREIGN KEY (product_id)
        REFERENCES product (product_id),
    FOREIGN KEY (order_id)
        REFERENCES orders (order_id),
    PRIMARY KEY (product_id , order_id)
);

insert into product(product_name, product_price, discount , stock)
values
("sp1",100,5,100),
("sp2",200,10,200),
("sp3",300,15,300),
("sp4",400,20,400),
("sp5",500,5,500),
("sp6",600,10,600),
("sp7",700,15,700),
("sp8",800,120,800),
("sp9",900,5,900),
("sp10",1100,10,1000);

insert into customer (customer_name, customer_birthday, customer_address, customer_email)
values
("customer_1", "1992-08-31", "abc", "abc1@abc.abc"),
("customer_2", "1992-08-01", "abcf", "abc2@abc.abc"),
("customer_3", "1992-08-02", "abcdsdgfd", "abc3@abc.abc"),
("customer_4", "1992-08-03", "abcsadfgh", "abc4@abc.abc"),
("customer_5", "1992-08-04", "abcdfs", "abc5@abc.abc"),
("customer_6", "1992-08-05", "abcfds", "abc6@abc.abc"),
("customer_7", "1992-08-06", "abcfds", "abc7@abc.abc"),
("customer_8", "1992-08-07", "abcfds", "abc8@abc.abc"),
("customer_9", "1992-08-08", "abcfsd", "abc9@abc.abc"),
("customer_10", "1992-08-09", "abcsfd", "abc10@abc.abc");

insert into employee (employee_name, employee_birthday, employee_address)
values
("employee_1","1992-07-31","address_1"),
("employee_2","1992-07-01","address_2"),
("employee_3","1992-07-02","address_3"),
("employee_4","1992-07-03","address_4"),
("employee_5","1992-07-04","address_5"),
("employee_6","1992-07-05","address_6"),
("employee_7","1992-07-06","address_7"),
("employee_8","1992-07-07","address_8"),
("employee_9","1992-07-08","address_9"),
("employee_10","1992-07-09","address_10");

insert into orders (order_payment_method, customer_id, employee_id, order_date, delivery_date, delivery_address)
values
("method_1",1,10,"2020-01-02","2020-02-02","address_1"),
("method_1",2,9,"2020-01-02","2020-02-02","address_2"),
("method_1",3,8,"2020-01-03","2020-02-03","address_3"),
("method_1",4,7,"2020-01-04","2020-02-04","address_4"),
("method_1",5,6,"2020-01-05","2020-02-05","address_5"),
("method_2",6,5,"2020-01-06","2020-02-06","address_6"),
("method_3",7,4,"2020-01-07","2020-02-07","address_7"),
("method_4",8,3,"2020-01-08","2020-02-08","address_8"),
("method_5",9,2,"2020-01-09","2020-02-09","address_9"),
("method_6",10,1,"2020-01-10","2020-02-10","address_10");

insert into order_product(product_id, order_id, quantity)
values
(1,1,20),
(2,2,10),
(3,3,30),
(4,4,40),
(5,5,50),
(6,6,60),
(7,7,70),
(8,8,80),
(9,9,90),
(10,10,100);

select product.product_id, product.product_name, product.product_price, product.discount, product.stock,`quantity` as sum(order_product.quantity)
from product left join order_product on product.product_id = order_product.product_id
group by product.product_id 
order by `quantity` DESC 
limit 3;




