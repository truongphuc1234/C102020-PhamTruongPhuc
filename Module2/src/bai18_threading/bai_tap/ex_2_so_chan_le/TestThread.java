package bai18_threading.bai_tap.ex_2_so_chan_le;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        Thread thread_1 = new Thread(oddThread);
        Thread thread_2 = new Thread(evenThread);

        thread_1.start();
        thread_1.join();
        thread_2.start();
    }
}
