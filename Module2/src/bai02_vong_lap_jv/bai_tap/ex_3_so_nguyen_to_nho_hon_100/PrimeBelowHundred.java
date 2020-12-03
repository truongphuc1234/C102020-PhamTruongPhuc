package bai02_vong_lap_jv.bai_tap.ex_3_so_nguyen_to_nho_hon_100;

public class PrimeBelowHundred {
    public static void main(String[] args) {
        for (int num =2;num <= 100; num ++){
            boolean check = true;
            int i = 2;
            while (i <= Math.sqrt(num)){
                if(num %i == 0){
                    check = false;
                    break;
                }
                i++;
            }
            if(check) {
                System.out.println(num);
            }
        }
    }
}
