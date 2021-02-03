package auto_generate;

import java.io.*;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Generator {

    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

    public static void main(String[] args) {
        List<String> ten = new ArrayList<>();
        List<String> ho = new ArrayList<>();
        List<String> dia_chi = new ArrayList<>();
        try (BufferedReader br_ten = new BufferedReader(new FileReader("src/auto_generate/data/ten.txt"));
             BufferedReader br_ho = new BufferedReader(new FileReader("src/auto_generate/data/ho.txt"));
             BufferedReader br_dia_chi = new BufferedReader(new FileReader("src/auto_generate/data/dia_chi.txt"))) {
            String line;
            while ((line = br_ten.readLine()) != null) {
                ten.add(line.trim());
            }
            while ((line = br_ho.readLine()) != null) {
                ho.add(line.trim());
            }
            while ((line = br_dia_chi.readLine()) != null) {
                dia_chi.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        generateNhanVien(ten, ho, dia_chi, 30, 6, 4, 4);
        generateKhachHang(ten, ho, dia_chi, 50, 5);
        generateHopDong(100, 30, 50, 10);
        generateHopDongChiTiet(200, 100, 5);

    }

    private static void generateNhanVien(List<String> ten, List<String> ho, List<String> dia_chi, int soNhanVien, int soViTri, int soTrinhDo, int soBoPhan) {
        try (BufferedWriter bw_nhanvien = new BufferedWriter(new FileWriter("src/auto_generate/nhan_vien.txt"));
             BufferedWriter bw_nhanvien_2 = new BufferedWriter(new FileWriter("src/auto_generate/nhan_vien_2.txt"))) {
            for (int i = 0; i < soNhanVien; i++) {
                bw_nhanvien.write("(");
                bw_nhanvien_2.write("(");
                String ho_ten = ho.get((int) (Math.random() * ho.size())) + " " + ten.get((int) (Math.random() * ten.size()));
                bw_nhanvien.write("'" + ho_ten + "',");

                int minDay = (int) LocalDate.of(1961, 1, 1).toEpochDay();
                int maxDay = (int) LocalDate.of(2003, 1, 1).toEpochDay();
                long randomDay = minDay + (long) (Math.random() * (maxDay - minDay));
                LocalDate randomBirthDay = LocalDate.ofEpochDay(randomDay);
                bw_nhanvien.write("'" + DateTimeFormatter.ofPattern("yyyy-MM-dd").format(randomBirthDay) + "',");

                bw_nhanvien.write("'"+(100_000_000 + (int) (Math.random() * 900_000_000)) + "',");
                bw_nhanvien.write(10_000_000 + (int) (Math.random() * 50_000_000) + ",");
                bw_nhanvien.write( "'"+(100_000_000 + (int) (Math.random() * 900_000_000)) + "',");
                bw_nhanvien.write((removeAccent("'" + ho_ten.replaceAll(" ", "")) + "@furama.com.vn',").toLowerCase());
                bw_nhanvien.write("'" + dia_chi.get((int) (Math.random() * dia_chi.size())) + "',");
                bw_nhanvien.write((int) (Math.random() * soViTri + 1) + ",");
                bw_nhanvien.write((int) (Math.random() * soTrinhDo + 1) + ",");
                bw_nhanvien.write((int) (Math.random() * soBoPhan + 1) + ",");
                bw_nhanvien.write((removeAccent("'" + ho_ten.replaceAll(" ", ""))+"'").toLowerCase());
                bw_nhanvien_2.write((removeAccent("'" + ho_ten.replaceAll(" ", ""))+"',").toLowerCase());
                bw_nhanvien_2.write((removeAccent("'" + ho_ten.replaceAll(" ", ""))+"'").toLowerCase());
                bw_nhanvien.write("),\n");
                bw_nhanvien_2.write("),\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void generateKhachHang(List<String> ten, List<String> ho, List<String> dia_chi, int soKhachHang, int soLoaiKhachHang) {
        try (BufferedWriter bw_nhanvien = new BufferedWriter(new FileWriter("src/auto_generate/khach_hang.txt"))) {
            for (int i = 0; i < soKhachHang; i++) {
                bw_nhanvien.write("(");
                bw_nhanvien.write((int) (Math.random() * soLoaiKhachHang + 1) + ",");
                String ho_ten = ho.get((int) (Math.random() * ho.size())) + " " + ten.get((int) (Math.random() * ten.size()));
                bw_nhanvien.write("'" + ho_ten + "',");
                int minDay = (int) LocalDate.of(1931, 1, 1).toEpochDay();
                int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
                long randomDay = minDay + (long) (Math.random() * (maxDay - minDay));
                LocalDate randomBirthDay = LocalDate.ofEpochDay(randomDay);
                bw_nhanvien.write("'" + DateTimeFormatter.ofPattern("yyyy-MM-dd").format(randomBirthDay) + "',");
                bw_nhanvien.write((int) (Math.random()  + 0.5) + ",");
                bw_nhanvien.write(100_000_000 + (int) (Math.random() * 900_000_000) + ",");
                bw_nhanvien.write(100_000_000 + (int) (Math.random() * 900_000_000) + ",");
                bw_nhanvien.write((removeAccent("'" + ho_ten.replaceAll(" ", "")) + "@gmail.com',").toLowerCase());
                bw_nhanvien.write("'" + dia_chi.get((int) (Math.random() * dia_chi.size())) + "'");
                bw_nhanvien.write("),\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateHopDong(int soHopDong, int soNhanVien, int soKhachHang, int soDichVu) {
        try (BufferedWriter bw_nhanvien = new BufferedWriter(new FileWriter("src/auto_generate/hop_dong.txt"))) {
            for (int i = 0; i < soHopDong; i++) {
                bw_nhanvien.write("(");
                bw_nhanvien.write((int) (Math.random() * soNhanVien + 1) + ",");
                bw_nhanvien.write((int) (Math.random() * soKhachHang + 1) + ",");
                bw_nhanvien.write((int) (Math.random() * soDichVu + 1) + ",");

                int minDay = (int) LocalDate.of(2016, 1, 1).toEpochDay();
                int maxDay = (int) LocalDate.of(2019, 12, 31).toEpochDay();
                long randomDay = minDay + (long) (Math.random() * (maxDay - minDay));
                LocalDate randomBirthDay = LocalDate.ofEpochDay(randomDay);
                bw_nhanvien.write("'" + DateTimeFormatter.ofPattern("yyyy-MM-dd").format(randomBirthDay) + "',");
                bw_nhanvien.write("'" + DateTimeFormatter.ofPattern("yyyy-MM-dd").format(randomBirthDay.plusDays((int) (Math.random() * 15 + 3))) + "',");
                int tienDatCoc = 1_000_000 + (int) (Math.random() * 9_000_000);
                bw_nhanvien.write(tienDatCoc + ",");
                bw_nhanvien.write(Integer.toString(tienDatCoc + (int) (Math.random() * 10_000_000)));
                bw_nhanvien.write("),\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateHopDongChiTiet(int soHopDongChiTiet, int soHopDong, int soDichVuDiKem) {
        try (BufferedWriter bw_nhanvien = new BufferedWriter(new FileWriter("src/auto_generate/hop_dong_chi_tiet.txt"))) {
            for (int i = 0; i < soHopDongChiTiet; i++) {
                bw_nhanvien.write("(");
                bw_nhanvien.write((int) (Math.random() * soHopDong + 1) + ",");
                bw_nhanvien.write((int) (Math.random() * soDichVuDiKem + 1) + ",");
                bw_nhanvien.write((int) (Math.random() * 20) + 1 + "");
                bw_nhanvien.write("),\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
