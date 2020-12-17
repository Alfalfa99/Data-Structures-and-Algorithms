package DesignPattern;

/**
 * @author Alfalfa99
 * @version 1.0
 * @date 2020/12/16 18:36
 * 双重锁检查锁懒汉单例
 */
public class LazySingleton {
    private volatile static LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance == null){
            synchronized (LazySingleton.class) {
                if (instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
