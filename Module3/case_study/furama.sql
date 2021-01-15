USE furama;
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
        AND (dia_chi = 'Đà Nẵng'
        OR dia_chi = 'Quảng Trị');
        
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

SELECT DISTINCT
    dich_vu_di_kem.id_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    dich_vu_di_kem.gia,
    dich_vu_di_kem.don_vi,
    dich_vu_di_kem.trang_thai_kha_dung
FROM
    hop_dong_chi_tiet
        INNER JOIN
    dich_vu_di_kem ON dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
        INNER JOIN
    hop_dong ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
        INNER JOIN
    khach_hang ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
        INNER JOIN
    loai_khach ON loai_khach.id_loai_khach = khach_hang.id_loai_khach
WHERE
    khach_hang.dia_chi IN ('Vinh' , 'Quảng Ngãi')
        AND loai_khach.ten_loai_khach = 'Diamond'
;

-- 12 Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt 
-- vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

SELECT 
    hop_dong.id_hop_dong AS `ID Hợp đồng`,
    nhan_vien.ho_ten AS `Họ tên Nhân viên`,
    khach_hang.ho_ten AS `Họ tên khách hàng`,
    khach_hang.sdt AS `SDT khách hàng`,
    dich_vu.ten_dich_vu AS `Tên dịch vụ`,
    SUM(hop_dong_chi_tiet.so_luong) AS `Số lượng dịch vụ đi kèm`,
    hop_dong.tien_dat_coc AS `Số tiền cọc`
FROM
    hop_dong
        INNER JOIN
    nhan_vien ON nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
        INNER JOIN
    khach_hang ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
        INNER JOIN
    hop_dong_chi_tiet ON hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
        INNER JOIN
    dich_vu ON dich_vu.id_dich_vu = hop_dong.id_dich_vu
WHERE
    hop_dong.id_dich_vu IN (SELECT 
            id_dich_vu
        FROM
            hop_dong
        WHERE
            ngay_lam_hop_dong BETWEEN '2019-10-01' AND '2019-12-31')
        AND hop_dong.id_dich_vu NOT IN (SELECT 
            id_dich_vu
        FROM
            hop_dong
        WHERE
            ngay_lam_hop_dong BETWEEN '2019-01-01' AND '2019-06-30')
GROUP BY hop_dong.id_hop_dong;

-- 13 Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

SELECT 
    dich_vu_di_kem.id_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    dich_vu_di_kem.gia,
    dich_vu_di_kem.don_vi,
    dich_vu_di_kem.trang_thai_kha_dung
FROM
    hop_dong_chi_tiet
        INNER JOIN
    dich_vu_di_kem ON dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
GROUP BY dich_vu_di_kem.id_dich_vu_di_kem
HAVING SUM(hop_dong_chi_tiet.so_luong) = (SELECT 
        MAX(temp.tong)
    FROM
        (SELECT 
            SUM(hop_dong_chi_tiet.so_luong) AS tong
        FROM
            hop_dong_chi_tiet
        GROUP BY id_dich_vu_di_kem) AS temp);

-- 14 Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

SELECT 
    hop_dong.id_hop_dong,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    COUNT(hop_dong_chi_tiet.id_dich_vu_di_kem) AS `So lan su dung`
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
        JOIN
    hop_dong ON hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
GROUP BY dich_vu_di_kem.id_dich_vu_di_kem
HAVING `So lan su dung` = 1;

-- 15 Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

SELECT 
    nhan_vien.id_nhan_vien,
    nhan_vien.ho_ten,
    trinh_do.loai_trinh_do,
    vi_tri.ten_vi_tri,
    nhan_vien.sdt,
    nhan_vien.dia_chi
FROM
    nhan_vien
        LEFT JOIN
    trinh_do ON trinh_do.id_trinh_do = nhan_vien.id_trinh_do
        LEFT JOIN
    vi_tri ON vi_tri.id_vi_tri = nhan_vien.id_vi_tri
        LEFT JOIN
    hop_dong ON hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN 2018 AND 2019
GROUP BY nhan_vien.id_nhan_vien
HAVING COUNT(hop_dong.id_hop_dong) <= 3;

-- 16 Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
DROP TABLE IF EXISTS temp;
CREATE TEMPORARY TABLE temp
	SELECT 
		hop_dong.id_nhan_vien
	FROM
		hop_dong
	WHERE
		YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN 2017 AND 2019;

DELETE hop_dong_chi_tiet FROM hop_dong_chi_tiet
        INNER JOIN
    hop_dong ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong 
WHERE
    hop_dong.id_nhan_vien NOT IN (SELECT 
        *
    FROM
        temp);
        
DELETE hop_dong FROM hop_dong 
WHERE
    hop_dong.id_nhan_vien NOT IN (SELECT 
        *
    FROM
        temp);
        
DELETE nhan_vien FROM nhan_vien 
WHERE
    nhan_vien.id_nhan_vien NOT IN (SELECT 
        *
    FROM
        temp);
        
DROP table temp;

-- 17 Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond,
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

UPDATE khach_hang 
SET 
    khach_hang.id_loai_khach = (SELECT 
            id_loai_khach
        FROM
            loai_khach
        WHERE
            ten_loai_khach = 'Diamond')
WHERE
    khach_hang.id_loai_khach = (SELECT 
            id_loai_khach
        FROM
            loai_khach
        WHERE
            ten_loai_khach = 'Platinum')
        AND khach_hang.id_khach_hang IN (SELECT 
            hop_dong.id_khach_hang
        FROM
            hop_dong
        WHERE
            YEAR(hop_dong.ngay_lam_hop_dong) = 2019
        GROUP BY hop_dong.id_khach_hang
        HAVING SUM(hop_dong.tong_tien) >= 1000000);

-- 18 Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
 
DROP TABLE IF EXISTS temp;
CREATE TEMPORARY TABLE temp
SELECT id_khach_hang FROM
    hop_dong
WHERE
    YEAR(ngay_lam_hop_dong) < 2016;
    
DELETE hop_dong_chi_tiet FROM hop_dong_chi_tiet
        JOIN
    hop_dong ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong 
WHERE
    hop_dong.id_khach_hang IN (SELECT 
        *
    FROM
        temp);
        
DELETE FROM hop_dong 
WHERE
    id_khach_hang IN (SELECT 
        *
    FROM
        temp);
        
DELETE FROM khach_hang 
WHERE
    id_khach_hang IN (SELECT 
        *
    FROM
        temp);
drop table temp;

-- 19 Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

UPDATE dich_vu_di_kem 
SET 
    dich_vu_di_kem.gia = dich_vu_di_kem.gia * 2
WHERE
    dich_vu_di_kem.id_dich_vu_di_kem IN (SELECT 
            hop_dong_chi_tiet.id_dich_vu_di_kem
        FROM
            hop_dong_chi_tiet
                JOIN
            hop_dong ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
        WHERE
            YEAR(hop_dong.ngay_lam_hop_dong) = 2019
        GROUP BY hop_dong_chi_tiet.id_dich_vu_di_kem
        HAVING COUNT(hop_dong_chi_tiet.id_dich_vu_di_kem) > 10);

-- 20 Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống,
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

SELECT 
    nhan_vien.id_nhan_vien AS `ID`,
    nhan_vien.ho_ten AS `Họ Tên`,
    nhan_vien.email AS `Email`,
    nhan_vien.sdt AS `Số điện thoại`,
    nhan_vien.ngay_sinh AS `Ngày Sinh`,
    nhan_vien.dia_chi AS `Địa Chỉ`
FROM
    nhan_vien 
UNION SELECT 
    khach_hang.id_khach_hang,
    khach_hang.ho_ten,
    khach_hang.email,
    khach_hang.sdt,
    khach_hang.ngay_sinh,
    khach_hang.dia_chi
FROM
    khach_hang;