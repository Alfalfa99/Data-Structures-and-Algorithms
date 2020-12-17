package DesignPattern;

/**
 * @author Alfalfa99
 * @version 1.0
 * @date 2020/12/16 18:35
 */
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){

    }
    public static EagerSingleton getInstance(){
        return instance;
    }
}
