package bai09_automated_test_tdd.bai_tap.ex_1_tinh_ngay_tiep_theo;

public class NextDayCalculator {

    public static final int FIRST_DAY = 1;
    public static final int FIRST_MONTH = 1;
    public static final int LAST_MONTH = 12;

    public static int[] getNextDay(int[] date) {

        int day = date[0];
        int month = date[1];
        int year = date[2];

        day++;

        if (day > getLastDayOfMonth(month, isLeapYear(year))) {
            day = FIRST_DAY;
            month++;
            if (month > LAST_MONTH) {
                month = FIRST_MONTH;
                year++;
            }
        }

        int[] nextDay = {day, month, year};

        return nextDay;
    }

    private static boolean isLeapYear(int year) {
        boolean isLeap;
        boolean isDivisibleBy4 = year % 4 == 0;

        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = year % 100 == 0;

            if (isDivisibleBy100) {
                boolean isDivisibleBy400 = year % 400 == 0;

                if (isDivisibleBy400) {
                    isLeap = true;
                } else
                    isLeap = false;
            } else
                isLeap = true;
        } else
            isLeap = false;
        return isLeap;
    }

    private static int getLastDayOfMonth(int month, boolean isLeapYear) {
        int days;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if (isLeapYear) {
                    days = 29;
                } else
                    days = 28;
                break;
            default:
                days = 0;
                break;
        }
        return days;
    }
}
