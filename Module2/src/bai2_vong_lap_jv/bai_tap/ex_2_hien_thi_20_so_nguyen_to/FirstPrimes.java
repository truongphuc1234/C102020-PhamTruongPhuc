package bai2_vong_lap_jv.bai_tap.ex_2_hien_thi_20_so_nguyen_to;

public class FirstPrimes {
    public static void main(String[] args) {
        int count = 0;
        int number = 2;
        while (count < 20){
            int i = 2;
            boolean check = true;
            while(i <= Math.sqrt(number)){
                if (number % i == 0){
                    check = false;
                    break;
                }
                i++;
            }
            if (check){
                System.out.println(number);
                count++;
            }
            number++;
        }
    }
}
