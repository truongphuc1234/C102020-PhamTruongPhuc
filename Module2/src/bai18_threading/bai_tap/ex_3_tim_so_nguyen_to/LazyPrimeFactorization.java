package bai18_threading.bai_tap.ex_3_tim_so_nguyen_to;

public class LazyPrimeFactorization implements Runnable {

    @Override
    public void run() {
        int count = 0;
        int number = 1;
        while (count != 100) {
            boolean isPrime = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("LazyPrimeFactorization: " + number);
                count++;
            }
            number++;
        }
    }
}