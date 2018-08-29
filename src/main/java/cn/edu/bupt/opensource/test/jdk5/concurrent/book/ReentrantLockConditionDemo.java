package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Title: ReentrantLockConditionDemo</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 16:37</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ReentrantLockConditionDemo implements Runnable{

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("Thread is going on.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread  = new Thread(new ReentrantLockConditionDemo());
        thread.start();
        Thread.sleep(2000);
        lock.lock();
        // 通知线程1继续执行
        condition.signal();
        lock.unlock();
    }


}
