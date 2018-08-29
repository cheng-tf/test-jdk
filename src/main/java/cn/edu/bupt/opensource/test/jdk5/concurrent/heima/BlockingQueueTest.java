package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <p>Title: BlockingQueueTest</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 23:12</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class BlockingQueueTest {

    public static void main(String[] args) {

        // BlockingQueue：阻塞队列
        final BlockingQueue queue = new ArrayBlockingQueue(3);

        for(int i = 0; i < 2; i++){
            new Thread(){
                public void run(){
                    while(true){
                        try {
                            Thread.sleep((long)(Math.random()*1000));
                            System.out.println(Thread.currentThread().getName() + "准备放数据!");
                            queue.put(1);
                            System.out.println(Thread.currentThread().getName() + "已经放了数据，" + "队列目前有" + queue.size() + "个数据");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }.start();
        }

        new Thread(){
            public void run(){
                while(true){
                    try {
                        // 将此处的睡眠时间分别改为100和1000，观察运行结果
                        Thread.sleep(30000);
                        System.out.println(Thread.currentThread().getName() + "准备取数据!");
                        queue.take();
                        System.out.println(Thread.currentThread().getName() + "已经取走数据，" + "队列目前有" + queue.size() + "个数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}
