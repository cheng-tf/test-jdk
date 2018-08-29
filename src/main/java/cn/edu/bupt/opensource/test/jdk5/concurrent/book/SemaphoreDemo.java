package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>Title: SemaphoreDemo</p>
 * <p>Description: 信号量Demo  </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 16:43</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class SemaphoreDemo implements Runnable{

    final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ":done!");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 信号量：控制访问资源的线程数
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        final SemaphoreDemo instance = new SemaphoreDemo();
        for(int i = 0; i < 20; i++) {
            threadPool.execute(instance);
        }
        threadPool.shutdown();
    }


}
