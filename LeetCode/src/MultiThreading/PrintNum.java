package MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alfalfa99
 * @version 1.0
 * @date 2020/12/16 18:47
 */
public class PrintNum {
    private static volatile int i = 1;
    private static final Object LOCK = new Object();
    public static void main(String[] args) {
        TestThread t = new TestThread();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程：打印完毕！");
    }
    private static class TestThread implements Runnable{

        @Override
        public void run() {
            synchronized (LOCK){
                while(i <= 100){
                    LOCK.notifyAll();
                    System.out.println(Thread.currentThread().getName() + ": " + i++);
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                LOCK.notifyAll();
            }
        }
    }

//    private static int count = 1;
//    private static final Object LOCK = new Object();
//
//    public static void main(String[] args) {
//        solution2();
//    }
//
//    public static void solution2() {
//
//        new Thread(() -> {
//            while (count < 100) {
//                synchronized (LOCK) {
//                    if ((count & 1) == 1) {
//                        System.out.println("奇数线程 -> " + count++);
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (count < 100) {
//                synchronized (LOCK) {
//                    if ((count & 1) == 0) {
//                        System.out.println("偶数线程 -> " + count++);
//                    }
//                }
//            }
//        }).start();
//    }
}
