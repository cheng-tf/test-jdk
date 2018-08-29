package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

/**
 * <p>Title: SynchronizedDemo</p>
 * <p>Description: 线程安全Demo </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 16:24</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class SynchronizedDemo implements Runnable{

    static SynchronizedDemo instance = new SynchronizedDemo();

    static int i = 0;

    // 进入此方法之前，必须先获得当前对象实例instance的锁
    private synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for(int j = 0; j < 10000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}
