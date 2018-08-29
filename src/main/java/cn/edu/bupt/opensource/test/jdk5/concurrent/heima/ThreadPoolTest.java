package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: ThreadPoolTest</p>
 * <p>Description: 线程池测试</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 21:04</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);       // 固定大小的线程池
        // ExecutorService threadPool = Executors.newCachedThreadPool();                // 缓存线程池
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();             // 单一线程池
        for(int i = 1; i <= 10; i++){
            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for(int j = 1;j <= 10; j++){
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " is looping of " + j + " for  task of " + task);
                    }
                }
            });
        }
        System.out.println("all of 10 tasks have committed! ");
        // threadPool.shutdownNow();

        // 使用线程池启动定时器
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("bombing!");
            }
        }, 6, 2, TimeUnit.SECONDS);
    }



}
