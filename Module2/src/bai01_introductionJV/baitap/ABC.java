package bai01_introductionJV.baitap;

public class ABC {

    public static int findSumMax(int[] arr){
        int sum = arr[0];
        int sumMax = arr[0];

        for(int i= 0; i < arr.length-1; i++){
            if(arr[i] < arr[i+1])
                sum += arr[i+1];
            else
                sum = arr[i+1];
            if(sum > sumMax)
                sumMax = sum;
        }
        return sumMax;
    }

    public static void main(String[] args) {
        System.out.println(findSumMax(new int[]{1,3,4,2,3,1,5,7}));
    }
}
