package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Title: ReentrantLockDemo</p>
 * <p>Description: 可重入锁Demo </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 16:30</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ReentrantLockDemo implements Runnable{

    private static ReentrantLock lock  = new ReentrantLock();

    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo instance = new ReentrantLockDemo();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}
