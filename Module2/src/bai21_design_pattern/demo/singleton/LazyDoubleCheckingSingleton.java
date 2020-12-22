package bai21_design_pattern.demo.singleton;

public class LazyDoubleCheckingSingleton {
    private static LazyDoubleCheckingSingleton instance;

    private LazyDoubleCheckingSingleton(){}

    public static LazyDoubleCheckingSingleton getInstance(){
        if(instance == null){
            synchronized (LazyDoubleCheckingSingleton.class){
                if(instance == null)
                    instance = new LazyDoubleCheckingSingleton();
            }
        }
        return instance;
    }
}
