package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>Title: ReadWriteLockDemo</p>
 * <p>Description: 读写锁Demo </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 16:49</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ReadWriteLockDemo {

    private static Lock lock = new ReentrantLock();

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static Lock readLock = readWriteLock.readLock();

    private static Lock writeLock = readWriteLock.writeLock();

    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();    // 模拟读操作
            Thread.sleep(1000);
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();    // 模拟写操作
            Thread.sleep(1000);
            value = index;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo instance = new ReadWriteLockDemo();

        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    instance.handleRead(readLock);
                    // instance.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    instance.handleWrite(writeLock, new Random().nextInt());
                    // instance.handleWrite(lock, new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(writeRunnable).start();
        }

    }

}
