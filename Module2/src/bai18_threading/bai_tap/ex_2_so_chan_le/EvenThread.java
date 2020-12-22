package bai18_threading.bai_tap.ex_2_so_chan_le;

public class EvenThread implements Runnable{
    @Override
    public void run() {
        try{
            for(int i = 0; i< 10;i+=2){
                System.out.println("Even Thread : "+i);
                Thread.sleep(15);
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
