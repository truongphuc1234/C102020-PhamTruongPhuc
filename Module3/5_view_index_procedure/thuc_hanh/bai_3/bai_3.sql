delimiter //
create procedure get_cus_by_id (IN cusNum INT)
begin
SELECT * from customers where customerNumber = cusNum;
end //
delimiter ;

call get_cus_by_id(175);

delimiter //
create procedure get_customers_count_by_city(IN in_city VARCHAR(50), out total int)
begin
select count(customerNumber)
into total 
from customers
where city = in_city;
end //
delimiter ;

call get_customers_count_by_city('Lyon', @total);
select @total;

delimiter //
create procedure set_counter(
INOUT counter int,
in inc int
)
begin
set counter = counter + inc;
end //
delimiter ;

SET @counter = 1;

CALL set_counter(@counter,1);
CALL set_counter(@counter,1);
CALL set_counter(@counter,5);
SELECT @counter;