package bai09_automated_test_tdd.bai_tap.ex_3_fizz_buzz;

public class FizzBuzzTranslate {
    public static String translate(int number) {

        boolean isDividedBy5 = number % 5 == 0;
        boolean isDividedBy3 = number % 3 == 0;

        if (isDividedBy5 && isDividedBy3) {
            return "FizzBuzz";
        }
        if (isDividedBy5) {
            return "Buzz";
        }
        if (isDividedBy3) {
            return "Fizz";
        }

        String result = "";
        do {
            int remain = number % 10;
            number = number / 10;
            result = numberToString(remain) + " " + result;
        } while (number > 0);

        return result.trim();
    }

    private static String numberToString(int number) {
        String stringNumber;
        switch (number) {
            case 1:
                stringNumber = "mot";
                break;
            case 2:
                stringNumber = "hai";
                break;
            case 3:
                stringNumber = "ba";
                break;
            case 4:
                stringNumber = "bon";
                break;
            case 5:
                stringNumber = "nam";
                break;
            case 6:
                stringNumber = "sau";
                break;
            case 7:
                stringNumber = "bay";
                break;
            case 8:
                stringNumber = "tam";
                break;
            case 9:
                stringNumber = "chin";
                break;
            case 0:
                stringNumber = "khong";
                break;
            default:
                stringNumber = "";
                break;
        }
        return stringNumber;
    }

}
