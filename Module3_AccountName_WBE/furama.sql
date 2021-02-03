drop database if EXISTS furama; 
create database furama;
use furama;

CREATE TABLE position (
    position_id INT PRIMARY KEY AUTO_INCREMENT,
    position_name VARCHAR(45)
);

CREATE TABLE education_degree (
    education_degree_id INT PRIMARY KEY AUTO_INCREMENT,
    education_degree_name VARCHAR(45)
);

CREATE TABLE division (
    division_id INT PRIMARY KEY AUTO_INCREMENT,
    division_name VARCHAR(45)
);

CREATE TABLE customer_type (
    customer_type_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_type_name VARCHAR(45)
);

CREATE TABLE role (
    role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(255)
);

CREATE TABLE user (
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255)
);

CREATE TABLE employee (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(45) NOT NULL,
    employee_birthday DATE NOT NULL,
    employee_id_card VARCHAR(45) NOT NULL,
    employee_salary DOUBLE NOT NULL,
    employee_phone VARCHAR(45) NOT NULL,
    employee_email VARCHAR(45),
    employee_address VARCHAR(45),
    position_id INT NOT NULL,
    education_degree_id INT NOT NULL,
    division_id INT NOT NULL,
    username VARCHAR(255),
    FOREIGN KEY (position_id)
        REFERENCES position (position_id),
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (education_degree_id),
    FOREIGN KEY (division_id)
        REFERENCES division (division_id),
    FOREIGN KEY (username)
        REFERENCES `user` (username)
);

CREATE TABLE customer (
    customer_id VARCHAR(45) PRIMARY KEY,
    customer_type_id INT NOT NULL,
    customer_name VARCHAR(45) NOT NULL,
    customer_birthday DATE NOT NULL,
    customer_gender BIT(1) NOT NULL,
    customer_id_card VARCHAR(45) NOT NULL,
    customer_phone VARCHAR(45) NOT NULL,
    customer_email VARCHAR(45),
    customer_address VARCHAR(45),
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (customer_type_id)
);

CREATE TABLE user_role (
    role_id INT,
    username VARCHAR(255),
    FOREIGN KEY (role_id)
        REFERENCES role (role_id),
    FOREIGN KEY (username)
        REFERENCES user (username),
    PRIMARY KEY (role_id , username)
);

CREATE TABLE attach_service (
    attach_service_id INT PRIMARY KEY AUTO_INCREMENT,
    attach_service_name VARCHAR(45) NOT NULL,
    attach_service_cost DOUBLE NOT NULL,
    attach_service_unit INT NOT NULL,
    attach_service_status VARCHAR(45)
);

CREATE TABLE rent_type (
    rent_type_id INT PRIMARY KEY AUTO_INCREMENT,
    rent_type_name VARCHAR(45),
    rent_type_cost DOUBLE
);

CREATE TABLE service_type (
    service_type_id INT PRIMARY KEY AUTO_INCREMENT,
    service_type_name VARCHAR(45)
);

CREATE TABLE service (
    service_id VARCHAR(45) PRIMARY KEY,
    service_name VARCHAR(45) NOT NULL,
    service_area INT,
    service_cost DOUBLE NOT NULL,
    service_max_people INT,
    rent_type_id INT NOT NULL,
    service_type_id INT NOT NULL,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors INT,
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (rent_type_id),
    FOREIGN KEY (service_type_id)
        REFERENCES service_type (service_type_id)
);

CREATE TABLE contract (
    contract_id INT PRIMARY KEY AUTO_INCREMENT,
    contract_start_date DATETIME NOT NULL,
    contract_end_date DATETIME NOT NULL,
    contract_deposit DOUBLE NOT NULL,
    contract_total_money DOUBLE NOT NULL,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    service_id INT NOT NULL,
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id),
    FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id),
    FOREIGN KEY (service_id)
        REFERENCES service (service_id)
);

CREATE TABLE contract_detail (
    contract_detail_id INT PRIMARY KEY,
    contract_id INT NOT NULL,
    attach_service_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (attach_service_id)
        REFERENCES attach_service (attach_service_id),
    FOREIGN KEY (contract_id)
        REFERENCES contract (contract_id)
);

INSERT INTO position (position_name) VALUES ('Lễ Tân'),('Phục Vụ'),('Chuyên viên'),('Giám Sát'),('Quản Lý'),('Giám Đốc');

INSERT INTO division(division_name) VALUES ('Sale-Marketing'),('Hành Chính'),('Phục Vụ'),('Quản Lý');
INSERT INTO education_degree(education_degree_name) VALUES ('Trung Cấp'),('Cao Đẳng'),('Đại Học'),('Sau Đại Học');
INSERT INTO service_type(service_type_name) VALUES ('Villa'),('House'),('Room');
INSERT INTO customer_type(customer_type_name) VALUES ('Diamond'),('Platinum'),('Gold'),('Silver'),('Member');
INSERT INTO role(role_name) VALUES ('admin'),('root'),('manager'),('user'),('director');

INSERT INTO attach_service(attach_service_name,attach_service_cost,attach_service_unit,attach_service_status)
VALUES
('massage',300000,5,'Có sẵn'),
('karaoke',150000,5,'Có sẵn'),
('Thức ăn',30000,30,'Có sẵn'),
('Nước uống',20000,15,'Có sẵn'),
('Thuê xe du lịch',500000,5,'Đang chuẩn bị');

INSERT INTO customer (customer_id,customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)
VALUES
('KH-0001',4,'Lê Kiến Văn','2013-06-08',1,392639103,230070989,'lekienvan@gmail.com','Huế'),
('KH-0002',1,'Vũ Phượng Long','1987-10-16',0,996833510,293743948,'vuphuonglong@gmail.com','Quảng Nam'),
('KH-0003',1,'Đỗ Trung Chính','1971-08-12',1,529730258,598464927,'dotrungchinh@gmail.com','Quảng Ngãi'),
('KH-0004',3,'Phan Mộng Nhi','1955-11-05',1,274007764,882781988,'phanmongnhi@gmail.com','Huế'),
('KH-0005',1,'Dương Công Án','1932-05-17',1,834661324,568993647,'duongcongan@gmail.com','Quảng Trị'),
('KH-0006',2,'Nguyễn Tấn Thành','1974-11-13',1,329830284,417834811,'nguyentanthanh@gmail.com','Quảng Trị'),
('KH-0007',5,'Lý Quang Vũ','2012-01-19',0,123135460,807339044,'lyquangvu@gmail.com','Huế'),
('KH-0008',5,'Đỗ Phương Mai','2007-11-23',1,607291895,661267145,'dophuongmai@gmail.com','Vinh'),
('KH-0009',4,'Lý Minh Duyên','1939-12-02',1,373763226,377493298,'lyminhduyen@gmail.com','Quảng Ngãi'),
('KH-0010',3,'Lê Phúc Hưng','1996-01-08',1,628222567,631738949,'lephuchung@gmail.com','Vinh'),
('KH-0011',2,'Vũ Quế Linh','2003-02-08',1,736586208,857045189,'vuquelinh@gmail.com','Vinh'),
('KH-0012',5,'Lý Hiểu Vân','1977-11-21',1,711385273,524374466,'lyhieuvan@gmail.com','Đà Nẵng'),
('KH-0013',2,'Hồ Phương Quỳnh','1931-03-02',0,573241192,274731873,'hophuongquynh@gmail.com','Quảng Trị'),
('KH-0014',5,'Lý Uyên Thy','1933-11-19',1,247210505,178196947,'lyuyenthy@gmail.com','Đà Nẵng'),
('KH-0015',2,'Ngô Kỳ Anh','1962-05-13',1,278764855,720256486,'ngokyanh@gmail.com','Quảng Ngãi'),
('KH-0016',1,'Trần Thời Nhiệm','1984-12-27',0,279171346,640828954,'tranthoinhiem@gmail.com','Quảng Ngãi'),
('KH-0017',1,'Đỗ Nhã Uyên','1933-08-30',0,335039381,376371238,'donhauyen@gmail.com','Đà Nẵng'),
('KH-0018',3,'Phạm Thiện Ngôn','1980-05-30',0,941799291,280458276,'phamthienngon@gmail.com','Quảng Ngãi'),
('KH-0019',2,'Đỗ Thắng Lợi','1964-06-02',1,845878425,123226172,'dothangloi@gmail.com','Đà Nẵng'),
('KH-0020',2,'Phan Mỹ Nhân','1943-11-08',1,505340552,295069531,'phanmynhan@gmail.com','Huế'),
('KH-0021',2,'Phạm Khuê Trung','2003-10-11',1,203753795,864983504,'phamkhuetrung@gmail.com','Quảng Trị'),
('KH-0022',5,'Đỗ Quý Khánh','1992-07-06',1,977053102,268941332,'doquykhanh@gmail.com','Đà Nẵng'),
('KH-0023',2,'Vũ Yên','1963-10-05',1,538162742,128697713,'vuyen@gmail.com','Đà Nẵng'),
('KH-0024',1,'Hoàng Lâm Nhi','1938-10-17',0,909144273,426409118,'hoanglamnhi@gmail.com','Đà Nẵng'),
('KH-0025',3,'Phạm Phương Trinh','1976-02-02',1,595635980,985461073,'phamphuongtrinh@gmail.com','Huế'),
('KH-0026',2,'Lê Thiên Mạnh','1960-09-11',0,163349023,232893606,'lethienmanh@gmail.com','Vinh'),
('KH-0027',3,'Lý Phi','1974-09-02',0,801386178,443814982,'lyphi@gmail.com','Đà Nẵng'),
('KH-0028',3,'Hồ Huỳnh','1946-12-05',0,882148752,993194833,'hohuynh@gmail.com','Vinh'),
('KH-0029',1,'Lê Ðăng Khoa','1989-10-22',1,252597154,965426824,'ledangkhoa@gmail.com','Đà Nẵng'),
('KH-0030',3,'Vũ Xuân Uyên','1994-09-18',0,616630894,297051903,'vuxuanuyen@gmail.com','Huế'),
('KH-0031',3,'Bùi Chí Nam','1936-02-14',1,493353651,553032446,'buichinam@gmail.com','Quảng Trị'),
('KH-0032',2,'Ngô Quỳnh Ngân','2002-04-24',1,560988937,361968197,'ngoquynhngan@gmail.com','Đà Nẵng'),
('KH-0033',2,'Lê Ðồng Khánh','1944-02-23',1,321211901,560644301,'ledongkhanh@gmail.com','Đà Nẵng'),
('KH-0034',4,'Ngô Việt Yến','1994-03-20',0,543663252,123302421,'ngovietyen@gmail.com','Huế'),
('KH-0035',2,'Lý Ðồng Bằng','1933-08-31',1,975410489,176025240,'lydongbang@gmail.com','Huế'),
('KH-0036',2,'Đặng Minh Nguyệt','1961-02-01',1,125122421,321625151,'dangminhnguyet@gmail.com','Vinh'),
('KH-0037',3,'Ngô Tâm Nguyên','1982-09-21',1,556722243,525427834,'ngotamnguyen@gmail.com','Huế'),
('KH-0038',3,'Phạm Ðông Phong','2012-05-17',0,852285243,437340989,'phamdongphong@gmail.com','Quảng Nam'),
('KH-0039',5,'Trần Tân Ðịnh','1938-05-03',1,628946344,850599403,'trantandinh@gmail.com','Đà Nẵng'),
('KH-0040',1,'Vũ Bình Ðạt','1959-08-20',1,219583368,522576401,'vubinhdat@gmail.com','Quảng Trị'),
('KH-0041',2,'Hồ Ánh Lệ','1990-12-13',1,252041456,708052683,'hoanhle@gmail.com','Đà Nẵng'),
('KH-0042',4,'Vũ Bá Thiện','1968-07-21',1,286664528,280333146,'vubathien@gmail.com','Đà Nẵng'),
('KH-0043',3,'Bùi Phước Lộc','1986-07-15',1,396899108,540602031,'buiphuocloc@gmail.com','Quảng Trị'),
('KH-0044',2,'Bùi Vành','1969-09-13',0,802736406,340907390,'buivanh@gmail.com','Quảng Trị'),
('KH-0045',5,'Vũ Xuân Uyên','1954-06-11',0,291758027,171165274,'vuxuanuyen@gmail.com','Quảng Trị'),
('KH-0046',4,'Lý Vân','1969-12-07',0,687551170,785574326,'lyvan@gmail.com','Quảng Ngãi'),
('KH-0047',3,'Lý Nhan','1960-12-06',0,550258815,168831331,'lynhan@gmail.com','Vinh'),
('KH-0048',1,'Bùi Phi Ðiệp','1962-07-24',1,219030527,967538553,'buiphidiep@gmail.com','Quảng Trị'),
('KH-0049',4,'Lý Thiên Trí','2002-05-27',0,931139499,237193237,'lythientri@gmail.com','Quảng Nam'),
('KH-0050',5,'Đặng Quỳnh Thơ','1982-03-02',1,777531544,180150013,'dangquynhtho@gmail.com','Quảng Ngãi');

INSERT INTO user (username, password)
VALUES
('nguyendiemthao','nguyendiemthao'),
('levantrang','levantrang'),
('hoangsonglam','hoangsonglam'),
('tranngocdoan','tranngocdoan'),
('nguyentonle','nguyentonle'),
('lythuckhue','lythuckhue'),
('buigiaphuc','buigiaphuc'),
('doyennhi','doyennhi'),
('buithequyen','buithequyen'),
('ngoquanglinh','ngoquanglinh'),
('buinamson','buinamson'),
('hohongchau','hohongchau'),
('phanmyhoan','phanmyhoan'),
('phanminhquan','phanminhquan'),
('phamdanthanh','phamđanthanh'),
('hoanghuyentram','hoanghuyentram'),
('nguyenbangson','nguyenbangson'),
('dangductri','dangductri'),
('buikhanhdan','buikhanhdan'),
('lytrucphuong','lytrucphuong'),
('vutruonggiang','vutruonggiang'),
('duongdinhtrung','duongdinhtrung'),
('tranhanhphuong','tranhanhphuong'),
('hoanhmai','hoanhmai'),
('buihoangkhang','buihoangkhang'),
('ngothanh','ngothanh'),
('tranphuchoa','tranphuchoa'),
('phamhan','phamhan'),
('lehongmai','lehongmai'),
('hothanhthe','hothanhthe');

INSERT INTO employee (employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username)
VALUES
('Nguyễn Diễm Thảo','1982-07-09','437297198',13558551,'266873688','nguyendiemthao@furama.com.vn','Quảng Trị',3,3,2,'nguyendiemthao'),
('Lê Vân Trang','1997-07-26','530316841',34841138,'905468542','levantrang@furama.com.vn','Huế',5,1,3,'levantrang'),
('Hoàng Song Lam','1966-06-07','505610892',38377459,'981581683','hoangsonglam@furama.com.vn','Vinh',1,1,3,'hoangsonglam'),
('Trần Ngọc Ðoàn','1969-06-17','176092663',31428816,'259362053','tranngocðoan@furama.com.vn','Quảng Trị',6,4,4,'tranngocðoan'),
('Nguyễn Tôn Lễ','1981-01-02','756155657',58074313,'607348315','nguyentonle@furama.com.vn','Vinh',5,2,1,'nguyentonle'),
('Lý Thục Khuê','1989-01-22','625150238',53994339,'356104197','lythuckhue@furama.com.vn','Huế',5,3,3,'lythuckhue'),
('Bùi Gia Phúc','1998-12-21','705667635',50347794,'280243389','buigiaphuc@furama.com.vn','Quảng Trị',1,4,1,'buigiaphuc'),
('Đỗ Yên Nhi','2001-01-25','193301840',58766527,'819347337','đoyennhi@furama.com.vn','Quảng Trị',5,2,4,'doyennhi'),
('Bùi Thế Quyền','2001-05-22','587219998',10629048,'473270191','buithequyen@furama.com.vn','Huế',4,1,1,'buithequyen'),
('Ngô Quang Linh','1993-10-28','983197569',54101903,'258548248','ngoquanglinh@furama.com.vn','Quảng Ngãi',3,3,1,'ngoquanglinh'),
('Bùi Nam Sơn','2002-08-04','146219864',27116966,'607854050','buinamson@furama.com.vn','Quảng Nam',1,4,1,'buinamson'),
('Hồ Hồng Châu','1962-12-03','523339432',44433739,'473990282','hohongchau@furama.com.vn','Huế',4,4,4,'hohongchau'),
('Phan Mỹ Hoàn','1988-03-06','260788504',21445965,'655700686','phanmyhoan@furama.com.vn','Huế',5,4,1,'phanmyhoan'),
('Phan Minh Quân','1986-02-04','775522968',16441290,'163040991','phanminhquan@furama.com.vn','Huế',4,1,4,'phanminhquan'),
('Phạm Đan Thanh','1998-10-12','400126570',29902320,'255221837','phamđanthanh@furama.com.vn','Đà Nẵng',3,3,2,'phamdanthanh'),
('Hoàng Huyền Trâm','1969-08-30','772599656',53219500,'710290316','hoanghuyentram@furama.com.vn','Đà Nẵng',6,2,2,'hoanghuyentram'),
('Nguyễn Bằng Sơn','1977-08-04','906829085',47224286,'271901435','nguyenbangson@furama.com.vn','Đà Nẵng',5,2,1,'nguyenbangson'),
('Đặng Ðức Trí','2002-07-29','134877901',41379950,'488451779','đangðuctri@furama.com.vn','Vinh',5,2,1,'dangductri'),
('Bùi Khánh Ðan','1982-05-05','214603739',28702846,'240276069','buikhanhðan@furama.com.vn','Quảng Nam',4,2,3,'buikhanhdan'),
('Lý Trúc Phương','1998-02-20','703032436',16726639,'894273377','lytrucphuong@furama.com.vn','Đà Nẵng',5,4,3,'lytrucphuong'),
('Vũ Trường Giang','1994-03-07','791458694',46544109,'436629612','vutruonggiang@furama.com.vn','Vinh',1,3,4,'vutruonggiang'),
('Dương Ðình Trung','1983-10-01','118066954',26425601,'794192277','duongðinhtrung@furama.com.vn','Vinh',3,1,1,'duongdinhtrung'),
('Trần Hạnh Phương','1961-04-28','330165094',23260976,'946052568','tranhanhphuong@furama.com.vn','Vinh',1,4,4,'tranhanhphuong'),
('Hồ Ánh Mai','1977-09-03','974675718',19425282,'658081415','hoanhmai@furama.com.vn','Đà Nẵng',3,4,3,'hoanhmai'),
('Bùi Hoàng Khang','1979-10-06','392661973',18230864,'505192193','buihoangkhang@furama.com.vn','Huế',6,3,1,'buihoangkhang'),
('Ngô Thanh','1982-11-15','573275876',12284931,'616173831','ngothanh@furama.com.vn','Quảng Trị',5,2,2,'ngothanh'),
('Trần Phúc Hòa','1989-03-26','953060236',23487904,'922820810','tranphuchoa@furama.com.vn','Đà Nẵng',2,4,1,'tranphuchoa'),
('Phạm Hân','1973-01-31','698032939',14531199,'184114130','phamhan@furama.com.vn','Quảng Ngãi',6,3,4,'phamhan'),
('Lê Hồng Mai','1981-10-30','975015215',31312181,'504274877','lehongmai@furama.com.vn','Quảng Ngãi',3,2,2,'lehongmai'),
('Hồ Thanh Thế','1995-12-22','753377310',36188534,'564074827','hothanhthe@furama.com.vn','Đà Nẵng',5,4,4,'hothanhthe');

delimiter //
create procedure delete_employee(in id int)
begin
delete contract_details from contract_details join contract on contract.contract_id = contract_details.contract_id where contract.employee_id = id;
delete from contract where contract.employee_id = id;
delete from employee where employee.employee_id = id;
end;
// delimiter