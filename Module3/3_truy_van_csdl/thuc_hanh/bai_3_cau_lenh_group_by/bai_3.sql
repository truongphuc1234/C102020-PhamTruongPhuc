USE classicmodels;

SELECT 
    status
FROM
    orders
GROUP BY status;

SELECT 
    status, COUNT(*) AS 'So luong status'
FROM
    orders
GROUP BY status;

SELECT 
    status, SUM(quantityOrdered * priceEach) AS amount
FROM
    orders
        INNER JOIN
    orderdetails ON orders.ordernumber = orderdetails.ordernumber
GROUP BY status;

SELECT 
    orderNumber, SUM(quantityOrdered * priceEach) AS total
FROM
    orderdetails
GROUP BY orderNumber;

SELECT 
    YEAR(orderDate) AS year,
    SUM(quantityOrdered * priceEach) AS total
FROM
    orders
        INNER JOIN
    orderdetails ON orders.orderNumber = orderdetails.orderNumber
WHERE
    status = 'shipped'
GROUP BY year
HAVING year > 2003;