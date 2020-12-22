package bai18_threading.bai_tap.ex_3_tim_so_nguyen_to;

public class Test {
    public static void main(String[] args) {
        LazyPrimeFactorization lazy = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimized = new OptimizedPrimeFactorization();

        Thread thread_1 = new Thread(lazy);
        Thread thread_2 = new Thread(optimized);

        thread_1.start();
        thread_2.start();
    }
}
