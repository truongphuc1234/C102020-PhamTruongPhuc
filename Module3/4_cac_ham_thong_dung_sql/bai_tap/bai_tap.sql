drop database if exists bai_tap;
create database bai_tap;

use bai_tap;

CREATE TABLE hoc_vien (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(20),
    tuoi INT,
    khoa_hoc VARCHAR(10),
    so_tien INT
);

insert into hoc_vien(ten,tuoi ,khoa_hoc,so_tien)
VALUES
('Hoang',21, 'CNTT', 400000),
('Viet',19, 'DTVT', 320000),
('Thanh',18, 'KTDN', 400000),
('Nhan',19, 'CK', 450000),
('Huong',20, 'TCNH', 500000),
('Huong',20, 'TCNH', 200000)
;

SELECT 
    *
FROM
    hoc_vien
WHERE
    ten = 'Huong';

SELECT 
    SUM(so_tien)
FROM
    hoc_vien
WHERE
    ten = 'Huong';

SELECT DISTINCT
    ten
FROM
    hoc_vien;