CREATE DATABASE furama;
USE furama;

CREATE TABLE vi_tri(
id_vi_tri INT PRIMARY KEY AUTO_INCREMENT,
ten_vi_tri VARCHAR(45)
);

CREATE TABLE trinh_do (
id_trinh_do INT PRIMARY KEY AUTO_INCREMENT,
trinh_do VARCHAR(45)
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
luong VARCHAR(45),
sdt VARCHAR(45),
email VARCHAR(45),
dich_vu VARCHAR(45)
);

CREATE TABLE loai_khach (
id_loai_khach INT PRIMARY KEY,
ten_loai_khach VARCHAR(45)
);

CREATE TABLE khach_hang (
id_khach_hang INT PRIMARY KEY,
id_loai_hang INT,
ho_ten VARCHAR(45),
ngay_sinh DATE,
so_cmnd VARCHAR(45),
sdt VARCHAR(45),
email VARCHAR(45),
dia_chi VARCHAR(45)
);

CREATE TABLE kieu_thue (
id_kieu_thue INT PRIMARY KEY,
ten_kieu_thue VARCHAR(45),
gia INT
);

CREATE TABLE loai_dich_vu (
id_loai_dich_vu INT PRIMARY KEY,
ten_loai_dich_vu VARCHAR(45)
);

CREATE TABLE dich_vu (
id_dich_vu INT PRIMARY KEY,
ten_dich_vu VARCHAR(45),
dien_tich INT,
so_tang INT,
so_nguoi_toi_da VARCHAR(45),
chi_phi_thue VARCHAR(45),
kieu_thue VARCHAR(45),
id_loai_dich_vu INT,
trang_thai VARCHAR(45)
);

CREATE TABLE dich_vu_di_kem (
id_dich_vu_di_kem INT PRIMARY KEY,
ten_dich_vu_di_kem VARCHAR(45),
gia INT,
don_vi INT,
trang_thai_kha_dung VARCHAR(45)
);

CREATE TABLE hop_dong_chi_tiet (
id_hop_dong_chi_tiet INT PRIMARY KEY,
id_hop_dong INT,
id_dich_vu_di_kem INT,
so_luong INT
);

CREATE TABLE hop_dong (
id_hop_dong INT PRIMARY KEY,
id_nhan_vien INT,
id_khach_hang INT,
id_dich_vu INT,
ngay_lam_hop_dong DATE,
ngay_ket_thuc DATE,
tien_dat_coc INT,
tong_tien INT
);

