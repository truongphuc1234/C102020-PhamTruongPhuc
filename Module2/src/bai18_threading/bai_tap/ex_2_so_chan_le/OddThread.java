package bai18_threading.bai_tap.ex_2_so_chan_le;

public class OddThread implements Runnable {
    @Override
    public void run() {
        try{
            for(int i = 1; i< 10;i+=2){
                System.out.println("Odd Thread : "+i);
                Thread.sleep(10);
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
