package bai18_threading.bai_tap.ex_1_thread_don_gian;

public class Main {
    public static void main(String[] args) {
        NumberGenerator generator_1 = new NumberGenerator();
        NumberGenerator generator_2 = new NumberGenerator();

        Thread thread_1 = new Thread(generator_1);
        Thread thread_2 = new Thread(generator_2);

        System.out.println(generator_1.hashCode());
        System.out.println(generator_2.hashCode());

        thread_2.setPriority(Thread.MAX_PRIORITY);
        thread_1.start();
        thread_2.start();

    }
}
