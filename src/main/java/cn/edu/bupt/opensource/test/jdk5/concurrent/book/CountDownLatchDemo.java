package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Title: CountDownLatch</p>
 * <p>Description: 倒计数器Demo </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 16:59</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class CountDownLatchDemo implements Runnable{

    static final CountDownLatch end = new CountDownLatch(10);

    static final CountDownLatchDemo instance = new CountDownLatchDemo();

    @Override
    public void run() {
        try {
            // 模拟检查任务
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete.");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(instance);
        }
        // 等待检查
        end.await();
        // 发射火箭
        System.out.println("Fire!");
        threadPool.shutdown();
    }


}
