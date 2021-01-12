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
    dich_vu VARCHAR(45),
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
    ngay_sinh, so_cmnd, luong, sdt, email, dich_vu)
VALUE 
('Hoang Lan Hong', 1, 1, 1, '1993-09-12', 123456789, 1234567893, 123456789, 'cho@gmai.com', 'Quảng Trị'),
('Nguyen Tien Van', 2, 2, 1, '1990-09-11', 123666789, 123666789, 123666789, 'occho@gmai.com', 'đà nẵng'),
('Tran Thu Do', 1, 3, 1, '2000-12-01', 123555789, 123555789, 123555789, 'meo@gmai.com', 'Quảng Trị'),
('Kim Long', 2, 4, 1, '1998-09-12', 123444789, 123444789, 123444789, 'asdsfbc@abc.com', 'huế'),
('Phan Kim Lien', 3, 1, 1, '1999-12-12', 13000000, 13000000, 13000000, 'heo@abc.com', 'đà nẵng'),
('Kim Binh Mai', 4, 2, 1, '1998-01-01', 242131, 242131, 242131, 'trau@abc.com', 'huế'),
('Hai Khi', 1, 3, 1, '1999-12-12', 23245, 4545, 345346, 'dog@abc.com', 'quảng nam'),
('Truong Tan Hai Hong', 2, 3, 3, '1985-12-12', 23245, 4545, 345346, 'haideptrai@xyz.com', 'quảng nam');

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
(1, 'Phan Trung Sơn', '1993-06-16', 1313213213, 1312312, 'nui@gmail.com', 'vinh'),
(1, 'Trần Ánh', '1995-10-10', 1313213213, 1312312, 'anh@gmail.com', 'quảng ngãi'),
(2, 'Nui Phan', '1999-12-12', 1313213213, 1312312, 'son@gmail.com', 'quảng trị'),
(3, 'Phan Nguyên', '1997-12-12', 1313213213, 1312312, 'abc@anc.com', 'đà nẵng'),
(1, 'Nguyễn Thanh Tùng', '1985-12-12', 1313213213, 1312312, 'abc@anc.com', 'đà nẵng'),
(3, 'Phan Thị Hồng Thanh', '2005-12-12', 1313213213, 1312312, 'abc@anc.com', 'quảng trị'),
(2, 'Lê Quang Dương', '1931-12-12', 1313213213, 1312312, 'abc@anc.com', 'đà nẵng');

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
('villa 5 sao', 123, 1, 7, 453232, 1, 2, 'trống'),
('villa 4 sao', 456, 2, 8, 22222, 2, 1, 'trống'),
('villa 3 sao', 893, 3, 9, 333333, 3, 3, 'trống'),
('villa 2 sao', 901, 4, 10, 232444312, 1, 2, 'hết'),
('phòng đơn 5 sao', 234, 11, 13, 555555, 2, 1, 'trống'),
('phòng đơn 4 sao', 567, 12, 13, 666666, 3, 3, 'trống'),
('phòng đơn 3 sao', 789, 13, 13, 777777, 1, 2, 'trống'),
('Nhà 5 sao', 222, 8, 13, 233342, 2, 1, 'trống'),
('Nhà 4 sao', 333, 9, 13, 123123, 3, 3, 'trống'),
('nhà 3 sao', 444, 10, 13, 981312, 1, 1, 'trống');

INSERT INTO hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, 
    ngay_ket_thuc, tien_dat_coc, tong_tien )
VALUE
(2, 5, 4, '2019-03-12', '1999-12-12', 12312162, 12212),
(3, 6, 5, '2019-02-12', '1999-12-12', 123126463, 145123123),
(4, 7, 6, '2019-01-14', '1999-12-12', 1231293, 1262),
(5, 1, 6, '2019-11-15', '1999-12-12', 1235123, 13261),
(6, 1, 4, '2019-11-16', '1999-12-12', 123123, 13123),
(7, 2, 3, '2019-10-17', '1999-12-12', 12311515, 161223),
(8, 3, 3, '2019-09-18', '1999-12-12', 123124163, 451223),
(1, 7, 7, '2018-01-12', '1999-12-12', 12312162, 12212),
(2, 5, 8, '2018-02-12', '1999-12-12', 123126463, 145123123),
(8, 4, 9, '2018-03-14', '1999-12-12', 1231293, 1262),
(2, 3, 5, '2018-12-15', '1999-12-12', 1235123, 13261),
(3, 2, 5, '2018-11-16', '1999-12-12', 123123, 13123),
(4, 1, 6, '2018-07-17', '1999-12-12', 12311515, 161223),
(5, 7, 7, '2018-09-18', '1999-12-12', 123124163, 451223);

INSERT INTO hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong)
VALUE
(1, 1, 10),
(2, 2, 13),
(3, 3, 14),
(4, 4, 15),
(5, 5, 20), 
(6, 1, 21), 
(7, 2, 22),
(1, 3, 23), 
(2, 4, 36), 
(3, 5, 67);

-- 2 Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K”
-- và có tối đa 15 ký tự.
SELECT 
    *
FROM
    nhan_vien
WHERE
    ho_ten REGEXP '\s[HTK]\w*$'
        AND LENGTH(ho_ten) <= 15;

-- 3 Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT 
    *
FROM
    khach_hang
WHERE
    ADDDATE(ngay_sinh, INTERVAL 18 YEAR) <= NOW()
        AND ADDDATE(ngay_sinh, INTERVAL 50 YEAR) >= NOW()
        AND (dia_chi = 'đà nẵng'
        OR dia_chi = 'quảng trị');
        
-- 4 Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

SELECT 
    khach_hang.ho_ten AS `Họ tên`,
    COUNT(hop_dong.id_hop_dong) AS `Số lần đặt phòng`
FROM
    khach_hang
        LEFT JOIN
    hop_dong ON hop_dong.id_khach_hang = khach_hang.id_khach_hang
        LEFT JOIN
    loai_khach ON loai_khach.id_loai_khach = khach_hang.id_loai_khach
WHERE
    loai_khach.ten_loai_khach = 'Diamond'
GROUP BY khach_hang.id_khach_hang;

-- 5 Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

SELECT 
    khach_hang.id_khach_hang AS `ID Khách Hàng`,
    khach_hang.ho_ten AS `Họ Tên`,
    loai_khach.ten_loai_khach AS `Tên Loại Khách`,
    hop_dong.id_hop_dong AS `ID Hợp Đồng`,
    dich_vu.ten_dich_vu AS `Tên Dịch Vụ`,
    ngay_lam_hop_dong AS `Ngày Làm Hợp Đồng`,
    ngay_ket_thuc AS `Ngày Kết Thúc`,
    dich_vu.chi_phi_thue + SUM(dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong) AS `Tổng Tiền`
FROM
    hop_dong
        RIGHT JOIN
    khach_hang ON hop_dong.id_khach_hang = khach_hang.id_khach_hang
        LEFT JOIN
    loai_khach ON loai_khach.id_loai_khach = khach_hang.id_loai_khach
        LEFT JOIN
    dich_vu ON hop_dong.id_dich_vu = dich_vu.id_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
GROUP BY khach_hang.id_khach_hang , hop_dong.id_hop_dong;

-- 6 Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt 
-- từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

SELECT 
    id_dich_vu AS `ID Dịch Vụ`,
    ten_dich_vu AS `Tên Dịch Vụ`,
    dien_tich AS `Diện Tích`,
    chi_phi_thue AS `Chi Phí Thuê`,
    loai_dich_vu.ten_loai_dich_vu AS `Tên Loại Dịch Vụ`
FROM
    dich_vu
        JOIN
    loai_dich_vu ON loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
WHERE
    id_dich_vu NOT IN (SELECT DISTINCT
            id_dich_vu
        FROM
            hop_dong
        WHERE
            ngay_lam_hop_dong BETWEEN '2018-12-31' AND '2019-04-01');
                
-- 7 Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
-- nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
SELECT 
    id_dich_vu AS `ID Dịch Vụ`,
    ten_dich_vu AS `Tên Dịch Vụ`,
    dien_tich AS `Diện Tích`,
    so_nguoi_toi_da AS `Số Người Tối Đa`,
    chi_phi_thue AS `Chi Phí Thuê`,
    ten_loai_dich_vu AS `Tên Loại Dịch Vụ`
FROM
    dich_vu
        JOIN
    loai_dich_vu ON dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
WHERE
    id_dich_vu IN (SELECT DISTINCT
            id_dich_vu
        FROM
            hop_dong
        WHERE
            YEAR(ngay_lam_hop_dong) = 2018)
        AND id_dich_vu NOT IN (SELECT DISTINCT
            id_dich_vu
        FROM
            hop_dong
        WHERE
            YEAR(ngay_lam_hop_dong) = 2019);
            
-- 8 Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Cach 1: 
SELECT DISTINCT
    ho_ten
FROM
    khach_hang;

-- Cach 2:
SELECT 
    ho_ten
FROM
    khach_hang
GROUP BY ho_ten;

-- Cach 3:
SELECT 
    ho_ten
FROM
    khach_hang 
UNION SELECT 
    ho_ten
FROM
    khach_hang;

-- 9 Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

SELECT 
    MONTH(ngay_lam_hop_dong) AS `Tháng`,
    COUNT(id_hop_dong) AS `Số lượng đặt phòng`
FROM
    hop_dong
WHERE
    YEAR(ngay_lam_hop_dong) = 2019
GROUP BY MONTH(ngay_lam_hop_dong)
ORDER BY MONTH(ngay_lam_hop_dong);

-- 10 Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet).

SELECT 
    hop_dong.id_hop_dong AS `ID Hợp Đồng`,
    ngay_lam_hop_dong AS `Ngày Làm Hợp Đồng`,
    ngay_ket_thuc AS `Ngày Kết Thúc`,
    tien_dat_coc AS `Tiền Đặt Cọc`,
    COUNT(hop_dong_chi_tiet.id_dich_vu_di_kem) AS `Số lượng Dịch vụ đi kèm`
FROM
    hop_dong
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
GROUP BY hop_dong.id_hop_dong
ORDER BY hop_dong.id_hop_dong;

-- 11 Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng 
-- có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

SELECT *
FROM
    hop_dong_chi_tiet
        INNER JOIN
    dich_vu_di_kem ON dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
        RIGHT JOIN
    hop_dong ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
        RIGHT JOIN
    khach_hang ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
        LEFT JOIN
    loai_khach ON loai_khach.id_loai_khach = khach_hang.id_loai_khach
;

