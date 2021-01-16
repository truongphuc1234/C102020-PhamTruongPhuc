-- 21 Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên
-- có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ 
-- với ngày lập hợp đồng là “12/12/2019”
CREATE VIEW v_nhanvien AS
    SELECT 
        *
    FROM
        nhan_vien
    WHERE
        dia_chi = 'Hảiv_nhanvien Châu'
            AND EXISTS( SELECT 
                hop_dong.id_nhan_vien
            FROM
                hop_dong
            WHERE
                hop_dong.ngay_lam_hop_dong = '2019-12-12'
                    AND hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien);

-- 22 Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất
-- cả các Nhân viên được nhìn thấy bởi khung nhìn này.
UPDATE v_nhanvien 
SET 
    v_nhanvien.dia_chi = 'Liên Chiểu';

-- 23 Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1

delimiter //
create procedure sp_1 (IN id int)
begin
delete hop_dong_chi_tiet from hop_dong_chi_tiet join hop_dong on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong where hop_dong.id_khach_hang = id;
DELETE FROM hop_dong 
WHERE
    id_khach_hang = id;
DELETE FROM khach_hang 
WHERE
    id_khach_hang = id;
end; //
delimiter

-- 24 Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 
-- phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được 
-- trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

delimiter //
create procedure sp_2 (in id_hop_dong int, in id_nhan_vien int, in id_khach_hang int ,in id_dich_vu int, in ngay_ket_thuc date, in tien_dat_coc int, in tong_tien int)
begin
    if(id_hop_dong not in (select id_hop_dong from hop_dong)) then
    if(idsp_1_nhan_vien in (select id_nhan_vien from nhan_vien)) then
    if(id_khach_hang in (select id_khach_hang from khach_hang))then
        insert into hop_dong
        values
        (id_hop_dong, id_nhan_vien, id_khach_hang,now(),ngay_ket_thuc,tien_dat_coc,tong_tien);
        end if;
        end if;
        END IF;
end; //

-- 25 Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database
select
-- 26 Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau:
-- Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu
--  không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database

select

-- 27 Tạo user function thực hiện yêu cầu sau:
-- 27a Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
-- 27b Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch
--  vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). \
-- Mã của Khách hàng được truyền vào như là 1 tham số của function này.

select
-- 28 Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 
--  để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu) và xóa những HopDong sử dụng dịch vụ liên quan 
-- (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác.

select