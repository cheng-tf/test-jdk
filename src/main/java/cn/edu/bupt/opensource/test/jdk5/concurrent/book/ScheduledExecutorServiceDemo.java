package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: ScheduledExecutorServiceDemo</p>
 * <p>Description: 计划任务 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 17:27</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(10);
        threadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);
    }

}
