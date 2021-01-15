select * from offices;

alter table offices add index country_index(country) ;

SELECT * FROM offices WHERE country = 'USA';

alter table offices drop index country_index;

alter table offices add index country_city_index(country,city);

SELECT * FROM offices WHERE country = 'USA' and  city = 'Boston';

