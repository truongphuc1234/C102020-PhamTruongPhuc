package bai04_class_object_java.bai_tap.ex_2_stop_watch;


public class Execution {
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        int[] array = new int[10000];
        for(int i = 0; i < 10000; i++){
            array[i] = (int)(Math.random()*1000);
        }

        stopWatch.start();

        for(int i = 0; i< array.length; i ++){
            for(int j = i+1; j< array.length; j++ ){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        stopWatch.end();

        System.out.println(stopWatch.getElapsedTime());
    }
}
