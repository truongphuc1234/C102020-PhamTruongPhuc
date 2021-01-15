delimiter //
create procedure find_all_customers()
begin
select * from customers;
end;
// delimiter ;

delimiter //
drop procedure IF EXISTS `find_all_customers` //
create procedure find_all_customers()
begin
select * from customers where customerNumber = 175;
end;
// delimiter ;