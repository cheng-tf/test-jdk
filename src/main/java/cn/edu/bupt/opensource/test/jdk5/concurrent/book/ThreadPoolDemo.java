package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Title: ThreadPoolDemo</p>
 * <p>Description: 线程池Demo </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 17:23</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ThreadPoolDemo {

    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            threadPool.submit(task);
        }
        threadPool.shutdown();
    }

}
