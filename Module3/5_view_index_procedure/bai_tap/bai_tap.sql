Skip to content
Search or jump to…

Pull requests
Issues
Marketplace
Explore
 
@truongphuc1234 
leechooncaao
/
C1020G1-LePhuocThanhCao
1
00
Code
Issues
Pull requests
Actions
Projects
Wiki
Security
Insights
C1020G1-LePhuocThanhCao/Module3/view_index_procedure/bai_tap/view_index_sp.sql
@leechooncaao
leechooncaao updated
Latest commit a49a616 15 hours ago
 History
 1 contributor
129 lines (103 sloc)  3.21 KB
  
CREATE DATABASE demo;

USE demo;

CREATE TABLE products(
		id INT AUTO_INCREMENT,
        product_code VARCHAR(10),
        product_name VARCHAR(20),
        product_price DECIMAL(9,2),
        product_amount INT,
        product_description VARCHAR(50),
        product_status VARCHAR(20),
        
        PRIMARY KEY (id)
);

INSERT INTO products (product_code, product_name, product_price, product_amount, product_description, product_status)
	VALUES 
		('FDS21', 'samsung s7', 2500.05, 15, 'nothing', 'available'),
		('EWQ12', 'samsung s8', 2400.00, 20, 'nothing', 'not available'),
		('UIY21', 'samsung s9', 2700.12, 10, 'nothing', 'available'),
		('EQWE2', 'samsung s6', 2000.00, 15, 'nothing', 'not available');
    
-- indexes    
CREATE UNIQUE INDEX idx_code ON products(product_code);

CREATE INDEX idx_name_price ON products(product_name, product_price);

EXPLAIN SELECT *
FROM products 
WHERE product_code = 'UIY21';

-- view
CREATE VIEW view_products AS
SELECT 
	product_code,
    product_name,
    product_price,
    product_status
FROM products;

UPDATE view_products
SET product_name = 'iphone 12'
WHERE product_code = 'UIY21';

DROP VIEW view_products;

-- procedures
DELIMITER //
CREATE PROCEDURE get_all_product()
BEGIN
	SELECT * 
    FROM products;
END;
// DELIMITER ;

CALL get_all_product();

DELIMITER //
CREATE PROCEDURE add_new_product(
		product_code VARCHAR(10),
        product_name VARCHAR(20),
        product_price DECIMAL(9,2),
        product_amount INT,
        product_description VARCHAR(50),
        product_status VARCHAR(20)
)
BEGIN
	INSERT INTO products (product_code, product_name, product_price, product_amount, product_description, product_status)
		VALUES (product_code, product_name, product_price, product_amount, product_description, product_status);
END;
// DELIMITER ;

CALL add_new_product('REWR2', 'sony z3', 2600.05, 15, 'nothing', 'not available');

DELIMITER //
CREATE PROCEDURE edit_product_by_id(
	product_id INT,
    product_code VARCHAR(10),
	product_name VARCHAR(20),
	product_price DECIMAL(9,2),
	product_amount INT,
	product_description VARCHAR(50),
	product_status VARCHAR(20)
)
BEGIN
	DECLARE count INT DEFAULT 0;
    SET count = (SELECT COUNT(id) FROM products WHERE id = product_id);
    
    IF count > 0 THEN 
		UPDATE products
			SET product_code = product_code, 
				product_name = product_name, 
				product_price= product_price, 
                product_amount = product_amount, 
                product_description = product_description, 
                product_status = product_status
		WHERE id = product_id;
	ELSE 
		SELECT  CONCAT('YOUR PARAMETER ', product_id, ' IS NOT EXISTS!!!') AS 'ERROR';
    END IF;
END;
// DELIMITER ;

CALL edit_product_by_id(2,'ERRE2', 'sony z1', 2700.05, 15, 'nothing', 'available');

CALL edit_product_by_id(12,'ERRE2', 'sony z1', 2700.05, 15, 'nothing', 'available');

DELIMITER //
CREATE PROCEDURE delete_product_by_id(product_id INT)
BEGIN
	DECLARE count INT DEFAULT 0;
    SET count = (SELECT COUNT(id) FROM products WHERE id = product_id);
    IF count > 0 THEN 
		DELETE FROM products
        WHERE id = product_id;
	ELSE 
		SELECT  CONCAT('YOUR PARAMETER ', product_id, ' IS NOT EXISTS!!!') AS 'ERROR';
    END IF;
END;
// DELIMITER ;

CALL delete_product_by_id(3);






© 2021 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
Pricing
API
Training
Blog
About
50 results found.