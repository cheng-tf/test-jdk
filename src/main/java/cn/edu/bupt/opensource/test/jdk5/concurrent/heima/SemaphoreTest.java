package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>Title: SemaphoreTest</p>
 * <p>Description: Semaphore测试 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 22:41</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        ExecutorService  threadPool = Executors.newCachedThreadPool();
        // Semaphore（信号量）：控制控制访问资源的线程个数，并提供同步机制
        final Semaphore semaphore = new Semaphore(3);
        for(int i = 0; i < 10; i++){
            Runnable runnable = new Runnable(){
                public void run(){
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "进入，当前已有" + (3 - semaphore.availablePermits()) + "个并发");
                    try {
                        Thread.sleep((long)(Math.random()*10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "即将离开");
                    semaphore.release();
                    //下面代码有时候执行不准确，因为其没有和上面的代码合成原子单元
                    System.out.println("线程" + Thread.currentThread().getName() + "已离开，当前已有" + (3 - semaphore.availablePermits()) + "个并发");
                }
            };
            threadPool.execute(runnable);
        }
    }

}
