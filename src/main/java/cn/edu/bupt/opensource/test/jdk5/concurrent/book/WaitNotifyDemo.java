package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

/**
 * <p>Title: WaitNotifyDemo</p>
 * <p>Description: 线程通信：wait/notify Demo </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 15:55</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class WaitNotifyDemo {

    final static Object object = new Object();

    public static class T1 implements Runnable {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ": T1 start!");
                try {
                    System.out.println(System.currentTimeMillis() + ": T1 wait for object");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": T1 end!");
            }
        }
    }

    public static class T2 implements Runnable {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ": T2 start! notify one thread");
                object.notify();
                System.out.println(System.currentTimeMillis() + ": T2 end!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // wait/notify：必须先获得对象的锁
        new Thread(new T1()).start();
        new Thread(new T2()).start();
    }

}
