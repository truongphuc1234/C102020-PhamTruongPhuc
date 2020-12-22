package bai21_design_pattern.demo.singleton;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance()
    {
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
