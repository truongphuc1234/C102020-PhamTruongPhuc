package bai19_string_regex.bai_tap.ex_1;

public class ValidateClass{
    public static boolean validate(String className){
        return className.matches("^[CAP][0-9]{4}[GHIKLM]$");
    }
}
