package bai18_threading.bai_tap.ex_1_thread_don_gian;

public class NumberGenerator implements Runnable {
    @Override
    public void run() {
        for(int i = 0;i < 10; i++){
            System.out.print(this.hashCode()+"\t:"+ i+"\n");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
