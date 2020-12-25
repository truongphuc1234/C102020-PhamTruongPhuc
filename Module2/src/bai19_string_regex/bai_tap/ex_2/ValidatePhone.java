package bai19_string_regex.bai_tap.ex_2;

public class ValidatePhone {
    public static boolean validate(String phone){
        return phone.matches("\\((\\d{2})\\)-\\(0(\\d{9})\\)");
    }
}
