-- create database

DROP DATABASE IF EXISTS furama;

CREATE DATABASE furama;
USE furama;

CREATE TABLE vi_tri (
    id_vi_tri INT PRIMARY KEY AUTO_INCREMENT,
    ten_vi_tri VARCHAR(45)
);

CREATE TABLE trinh_do (
    id_trinh_do INT PRIMARY KEY AUTO_INCREMENT,
    loai_trinh_do VARCHAR(45)
);

CREATE TABLE bo_phan (
    id_bo_phan INT PRIMARY KEY AUTO_INCREMENT,
    ten_bo_phan VARCHAR(45)
);

CREATE TABLE nhan_vien (
    id_nhan_vien INT PRIMARY KEY AUTO_INCREMENT,
    ho_ten VARCHAR(50),
    id_vi_tri INT,
    id_trinh_do INT,
    id_bo_phan INT,
    ngay_sinh DATE,
    so_cmnd VARCHAR(45),
    luong INT,
    sdt VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    FOREIGN KEY (id_vi_tri)
        REFERENCES vi_tri (id_vi_tri),
    FOREIGN KEY (id_trinh_do)
        REFERENCES trinh_do (id_trinh_do),
    FOREIGN KEY (id_bo_phan)
        REFERENCES bo_phan (id_bo_phan)
);

CREATE TABLE loai_khach (
    id_loai_khach INT PRIMARY KEY AUTO_INCREMENT,
    ten_loai_khach VARCHAR(45)
);

CREATE TABLE khach_hang (
    id_khach_hang INT PRIMARY KEY AUTO_INCREMENT,
    id_loai_khach INT,
    ho_ten VARCHAR(45),
    ngay_sinh DATE,
    so_cmnd VARCHAR(45),
    sdt VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    FOREIGN KEY (id_loai_khach)
        REFERENCES loai_khach (id_loai_khach)
);

CREATE TABLE kieu_thue (
    id_kieu_thue INT PRIMARY KEY AUTO_INCREMENT,
    ten_kieu_thue VARCHAR(45),
    gia INT
);

CREATE TABLE loai_dich_vu (
    id_loai_dich_vu INT PRIMARY KEY AUTO_INCREMENT,
    ten_loai_dich_vu VARCHAR(45)
);

CREATE TABLE dich_vu (
    id_dich_vu INT PRIMARY KEY AUTO_INCREMENT,
    ten_dich_vu VARCHAR(45),
    dien_tich INT,
    so_tang INT,
    so_nguoi_toi_da INT,
    chi_phi_thue INT,
    kieu_thue VARCHAR(45),
    id_loai_dich_vu INT,
    trang_thai VARCHAR(45),
    id_kieu_thue INT,
    FOREIGN KEY (id_loai_dich_vu)
        REFERENCES loai_dich_vu (id_loai_dich_vu),
    FOREIGN KEY (id_kieu_thue)
        REFERENCES kieu_thue (id_kieu_thue)
);

CREATE TABLE dich_vu_di_kem (
    id_dich_vu_di_kem INT PRIMARY KEY AUTO_INCREMENT,
    ten_dich_vu_di_kem VARCHAR(45),
    gia INT,
    don_vi INT,
    trang_thai_kha_dung VARCHAR(45)
);

CREATE TABLE hop_dong (
    id_hop_dong INT PRIMARY KEY AUTO_INCREMENT,
    id_nhan_vien INT,
    id_khach_hang INT,
    id_dich_vu INT,
    ngay_lam_hop_dong DATE,
    ngay_ket_thuc DATE,
    tien_dat_coc INT,
    tong_tien INT,
    FOREIGN KEY (id_nhan_vien)
        REFERENCES nhan_vien (id_nhan_vien),
    FOREIGN KEY (id_khach_hang)
        REFERENCES khach_hang (id_khach_hang),
    FOREIGN KEY (id_dich_vu)
        REFERENCES dich_vu (id_dich_vu)
);


CREATE TABLE hop_dong_chi_tiet (
    id_hop_dong_chi_tiet INT PRIMARY KEY AUTO_INCREMENT,
    id_hop_dong INT,
    id_dich_vu_di_kem INT,
    so_luong INT,
    FOREIGN KEY (id_dich_vu_di_kem)
        REFERENCES dich_vu_di_kem (id_dich_vu_di_kem),
    FOREIGN KEY (id_hop_dong)
        REFERENCES hop_dong (id_hop_dong)
);

-- 1 insert values

INSERT INTO vi_tri(ten_vi_tri)
VALUE 
('lễ tân'), 
('phục vụ'),
('chuyên viên'),
('giám sát'),
('quản lý'), 
('giám đốc');

INSERT INTO trinh_do (loai_trinh_do)
VALUE 
('trung cấp'),
('cao đẳng'),
('đại học'),
('sau đại học');

INSERT INTO bo_phan(ten_bo_phan)
VALUE
('sale- marketing'),
('hành chính'),
('phục vụ'),
('quản lý');

INSERT INTO nhan_vien(ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, 
    ngay_sinh, so_cmnd, luong, sdt, email, dia_chi)
VALUE ('Phạm Ngọc Huy',4,4,2,'2000-05-21',247062920,39198365,767036461,'phamngochuy@furama.com.vn','Huế'),
('Đỗ Hoài Vỹ',6,1,3,'1996-09-01',236855413,37373195,195470055,'đohoaivy@furama.com.vn','Đà Nẵng'),
('Phan Bá Kỳ',2,2,4,'1981-05-12',353379833,27150850,941861658,'phanbaky@furama.com.vn','Quảng Nam'),
('Đặng Anh Thư',2,3,1,'2002-08-20',313269069,20492416,555457679,'đanganhthu@furama.com.vn','Quảng Nam'),
('Phan Ðình Nhân',6,4,1,'1973-04-29',334714850,41467839,870532263,'phanðinhnhan@furama.com.vn','Huế'),
('Đặng Bình An',1,2,2,'1981-08-09',565921391,11788073,611244110,'đangbinhan@furama.com.vn','Quảng Nam'),
('Bùi Khuyên',4,1,1,'1985-05-06',288119789,26010887,326479092,'buikhuyen@furama.com.vn','Quảng Ngãi'),
('Phan Thiều',1,1,1,'1976-10-09',750459799,38532090,805881278,'phanthieu@furama.com.vn','Huế'),
('Hoàng Vân Du',6,1,2,'1997-02-21',286877995,21508750,387518734,'hoangvandu@furama.com.vn','Quảng Trị'),
('Lê Thuần Hậu',4,3,2,'1985-04-09',848919719,10345582,105177264,'lethuanhau@furama.com.vn','Quảng Nam'),
('Đỗ Trung Chính',5,3,4,'1963-04-11',952625095,43077713,529845556,'đotrungchinh@furama.com.vn','Quảng Trị'),
('Phan Bá Cường',3,1,2,'1977-10-23',728950372,37576343,909086013,'phanbacuong@furama.com.vn','Huế'),
('Phạm Đoan Trang',1,3,2,'1963-08-29',815569348,18068346,581023615,'phamđoantrang@furama.com.vn','Quảng Nam'),
('Hồ Tường Lân',5,1,1,'1977-10-25',170884493,10983125,150791122,'hotuonglan@furama.com.vn','Quảng Nam'),
('Phan Nam Dương',4,4,4,'1964-10-07',899082064,32012452,638414355,'phannamduong@furama.com.vn','Quảng Nam');

INSERT INTO dich_vu_di_kem (ten_dich_vu_di_kem, gia, don_vi, trang_thai_kha_dung)
VALUE
('massage', 100, 1, 'not ok'),
('karaoke', 100, 1, 'ok'),
('thức ăn', 50, 1, 'ok'),
('nước uống', 25, 1, 'ok'),
('xe tham quan resort', 300, 1, 'not ok');

INSERT INTO loai_khach (ten_loai_khach)
VALUE 
('Diamond'),
('Platinum'),
('Gold'),
('Silver'),
('Member');

INSERT INTO khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmnd, sdt, email, dia_chi)
VALUE
(5,'Trần Huyền Trang','2010-08-11',807862921,101707167,'tranhuyentrang@furama.com.vn','Quảng Ngãi'),
(2,'Đỗ Yến Mai','1937-11-15',594785828,179471729,'đoyenmai@furama.com.vn','Đà Nẵng'),
(2,'Hồ Thanh Loan','1980-07-09',582230270,733583364,'hothanhloan@furama.com.vn','Quảng Trị'),
(5,'Đỗ Thụy','1960-03-16',444430843,700841058,'đothuy@furama.com.vn','Quảng Nam'),
(5,'Phan Tố Nga','2009-12-22',499524381,470023797,'phantonga@furama.com.vn','Quảng Trị'),
(4,'Phạm Duy Thông','1945-01-27',819877807,328451520,'phamduythong@furama.com.vn','Vinh'),
(5,'Trần Hồ Diệp','1938-11-11',298291950,636149223,'tranhodiep@furama.com.vn','Vinh'),
(2,'Hồ Hạ Giang','1960-10-31',610992824,715921882,'hohagiang@furama.com.vn','Đà Nẵng'),
(2,'Vũ Lập Thành','1955-03-23',350433180,460798730,'vulapthanh@furama.com.vn','Quảng Nam'),
(1,'Dương Từ Ân','1942-07-27',501862749,109696861,'duongtuan@furama.com.vn','Đà Nẵng'),
(4,'Bùi Khắc Tuấn','1977-01-21',255287558,398846325,'buikhactuan@furama.com.vn','Đà Nẵng'),
(5,'Ngô Tân Ðịnh','1992-01-13',669025406,727614655,'ngotanðinh@furama.com.vn','Đà Nẵng'),
(2,'Đỗ Thành Phương','1969-01-05',725656579,849825393,'đothanhphuong@furama.com.vn','Đà Nẵng'),
(5,'Nguyễn Thiên Lạc','1976-05-24',253659687,149539138,'nguyenthienlac@furama.com.vn','Đà Nẵng'),
(1,'Ngô Bích','2010-07-27',570993980,662647691,'ngobich@furama.com.vn','Quảng Ngãi'),
(3,'Lý Nhã Yến','1937-01-28',761463954,856914720,'lynhayen@furama.com.vn','Quảng Ngãi'),
(1,'Lý Mạnh Hùng','1993-04-15',388765703,796598863,'lymanhhung@furama.com.vn','Vinh'),
(4,'Vũ Hoa','1944-06-13',203662725,688115634,'vuhoa@furama.com.vn','Quảng Nam'),
(5,'Hoàng Vân Quỳnh','2012-01-21',953500299,662082949,'hoangvanquynh@furama.com.vn','Quảng Ngãi'),
(1,'Vũ Thảo Uyên','1978-04-16',499112105,781958257,'vuthaouyen@furama.com.vn','Quảng Ngãi'),
(3,'Hoàng Hùng Ngọc','2003-08-22',945196740,633057806,'hoanghungngoc@furama.com.vn','Vinh'),
(5,'Phạm Quốc Hạnh','1957-10-25',182799120,869852830,'phamquochanh@furama.com.vn','Đà Nẵng'),
(4,'Dương Thụy Khanh','1937-11-20',333845178,934975239,'duongthuykhanh@furama.com.vn','Vinh'),
(1,'Phạm Phượng Nhi','1952-11-17',193056117,303355974,'phamphuongnhi@furama.com.vn','Quảng Trị'),
(4,'Hoàng Bình Ðạt','1985-11-09',157602333,806473630,'hoangbinhðat@furama.com.vn','Đà Nẵng'),
(3,'Nguyễn Ðức Tâm','1957-01-05',257389365,697352086,'nguyenðuctam@furama.com.vn','Quảng Trị'),
(2,'Phạm Anh Sơn','1951-06-30',319837219,585164220,'phamanhson@furama.com.vn','Vinh'),
(2,'Ngô Diễm Thư','1945-02-14',644733045,857180826,'ngodiemthu@furama.com.vn','Quảng Trị'),
(3,'Lý Đông','1943-04-02',129454968,413642354,'lyđong@furama.com.vn','Quảng Nam'),
(3,'Hồ Trường Sơn','1988-03-20',265912436,691619464,'hotruongson@furama.com.vn','Đà Nẵng');

INSERT INTO loai_dich_vu(ten_loai_dich_vu)
VALUE 
('villa'),
('house'),
('room');

INSERT INTO kieu_thue(ten_kieu_thue, gia)
VALUE 
('giờ',500),
('ngày',1000),
('tháng',2000);

INSERT INTO dich_vu(ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, kieu_thue,
     id_loai_dich_vu, trang_thai)
VALUE
('villa 5 sao', 123, 1, 7, 10738873, 1, 2, 'trống'),
('villa 4 sao', 456, 2, 8, 10465956, 2, 1, 'trống'),
('villa 3 sao', 893, 3, 9, 14717699, 3, 3, 'trống'),
('villa 2 sao', 901, 4, 10, 8998290, 1, 2, 'hết'),
('phòng đơn 5 sao', 234, 11, 13, 17430992, 2, 1, 'trống'),
('phòng đơn 4 sao', 567, 12, 13, 8067854, 3, 3, 'trống'),
('phòng đơn 3 sao', 789, 13, 13, 7677411, 1, 2, 'trống'),
('Nhà 5 sao', 222, 8, 13, 2520158, 2, 1, 'trống'),
('Nhà 4 sao', 333, 9, 13, 2166474, 3, 3, 'trống'),
('nhà 3 sao', 444, 10, 13, 9884581, 1, 1, 'trống');

INSERT INTO hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, 
    ngay_ket_thuc, tien_dat_coc, tong_tien )
VALUE
(1,18,9,'2015-06-25','2017-07-01',5233099,15038167),
(5,13,8,'2017-08-31','2017-09-17',8920374,13059793),
(14,27,2,'2017-08-19','2017-08-26',1636319,2473416),
(2,26,7,'2018-12-15','2018-12-30',9540220,14529178),
(2,7,10,'2016-09-23','2016-09-27',9719075,12134639),
(3,16,9,'2015-12-18','2016-12-25',3025195,12382896),
(6,2,7,'2019-04-24','2019-05-07',4533102,7341236),
(11,21,4,'2018-10-23','2018-11-02',7496702,9165269),
(3,12,10,'2018-09-07','2018-09-10',8785519,11212117),
(12,23,3,'2018-06-11','2018-06-25',5091165,5323004),
(11,11,8,'2016-12-12','2016-12-16',5337270,6633044),
(14,19,6,'2018-02-09','2018-02-13',9281157,14794382),
(2,2,2,'2016-08-07','2016-08-15',3362787,11285799),
(7,1,9,'2018-02-18','2018-03-06',8942572,14584008),
(13,30,6,'2016-02-14','2016-02-17',8861463,10547764),
(10,23,7,'2017-10-10','2017-10-26',9653234,15646795),
(3,7,7,'2016-05-10','2016-05-26',7614658,8885681),
(8,7,3,'2016-11-13','2016-11-19',5456852,10278195),
(8,25,5,'2018-01-01','2018-01-10',5141204,5553441),
(9,30,1,'2019-01-03','2019-01-14',6508138,6697457),
(7,5,1,'2016-01-12','2016-01-25',4283154,7596457),
(15,24,6,'2017-06-26','2017-07-09',4217380,6010621),
(10,14,5,'2019-10-23','2019-05-31',7924753,8703449),
(13,29,9,'2017-07-16','2017-07-20',4556925,13221588),
(3,12,9,'2017-08-04','2017-08-13',4043492,7122234),
(12,2,9,'2016-01-03','2016-01-20',2383543,6722786),
(6,24,9,'2019-11-03','2019-04-16',3954172,5664469),
(9,12,7,'2016-10-17','2016-10-22',2009715,3119657),
(8,27,8,'2016-08-18','2016-09-01',4736298,7713611),
(5,7,3,'2016-06-17','2016-06-21',1847670,7531378),
(3,12,5,'2018-05-17','2018-06-02',5541993,11771819),
(13,11,9,'2019-05-18','2019-05-30',3011554,11448202),
(1,15,6,'2016-07-27','2016-08-12',4735860,11539774),
(2,21,10,'2019-01-24','2019-02-08',5038381,10925746),
(1,19,6,'2018-04-18','2018-04-22',5698827,8125968),
(1,28,1,'2017-10-30','2017-11-07',9855064,11548959),
(8,8,10,'2017-07-31','2017-08-06',9073524,13989686),
(11,3,2,'2019-05-15','2019-05-31',5238759,6221974),
(5,11,2,'2018-05-09','2018-05-26',4286958,4598542),
(5,4,8,'2016-12-30','2017-01-04',3987182,13031095),
(15,3,3,'2016-10-18','2016-10-21',5264441,12943985),
(4,11,8,'2016-11-18','2016-11-27',5015237,6111835),
(1,17,8,'2019-01-04','2019-01-20',1363499,4626879),
(1,9,4,'2017-07-27','2017-08-04',6539216,6629905),
(12,7,5,'2017-10-04','2017-10-13',7083738,11773151),
(6,23,6,'2019-04-20','2019-05-06',1299422,5491594),
(15,13,1,'2017-11-18','2017-12-01',2033858,4843207),
(5,13,8,'2017-06-27','2017-07-01',3540079,5640099),
(6,21,8,'2019-04-30','2019-05-17',9804767,13187556),
(11,19,1,'2016-01-28','2016-02-08',9830095,19508549);

INSERT INTO hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong)
VALUE
(43,4,5),
(39,2,4),
(39,4,12),
(23,2,6),
(40,4,4),
(41,3,11),
(40,1,20),
(43,2,7),
(20,4,6),
(37,1,4),
(50,2,19),
(10,1,4),
(31,4,11),
(10,1,14),
(45,3,7),
(24,4,16),
(25,2,2),
(19,3,11),
(36,4,14),
(33,2,8),
(15,2,2),
(20,3,9),
(47,2,17),
(6,3,17),
(23,4,9),
(3,1,15),
(14,2,14),
(21,2,18),
(10,4,13),
(19,1,4),
(11,2,4),
(44,4,10),
(43,4,5),
(3,4,13),
(39,4,10),
(21,1,6),
(20,1,13),
(15,3,6),
(50,3,19),
(26,4,15),
(11,3,13),
(28,2,20),
(3,4,9),
(24,4,7),
(28,1,20),
(6,1,2),
(50,4,17),
(42,4,17),
(16,3,6),
(25,1,1),
(41,2,4),
(26,1,16),
(44,4,4),
(30,3,8),
(6,2,4),
(20,4,11),
(27,4,12),
(32,4,19),
(31,3,11),
(41,4,8),
(43,2,10),
(42,2,17),
(24,4,2),
(30,2,6),
(50,4,19),
(18,4,1),
(3,2,9),
(9,1,20),
(49,4,10),
(8,3,3),
(48,3,14),
(16,3,17),
(9,3,9),
(42,4,2),
(22,3,4),
(12,3,17),
(1,4,1),
(10,1,19),
(32,2,6),
(25,4,9),
(49,3,18),
(33,3,6),
(21,4,20),
(24,3,1),
(29,3,14),
(46,4,20),
(12,3,9),
(7,4,20),
(44,4,4),
(46,4,11),
(48,4,20),
(46,1,18),
(34,3,6),
(30,2,12),
(10,2,6),
(12,1,5),
(15,2,20),
(29,1,14),
(3,1,13),
(10,4,16),
(31,5,10);