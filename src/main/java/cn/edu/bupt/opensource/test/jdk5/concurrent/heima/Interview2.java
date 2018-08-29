package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * <p>Title: Interview2</p>
 * <p>Description: 空中网 面试题2 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 23:56</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class Interview2 {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);

        final SynchronousQueue<String> queue =  new SynchronousQueue<>();

        for(int i = 0 ; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        String input = queue.take();
                        String output = TestDo.doSome(input);
                        System.out.println(Thread.currentThread().getName()+ ":" + output);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        System.out.println("begin:"+(System.currentTimeMillis()/1000));
        for(int i=0;i<10;i++){  //这行不能改动
            String input = i+"";  //这行不能改动
            try {
                queue.put(input);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//不能改动此TestDo类
class TestDo {
    public static String doSome(String input){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String output = input + ":"+ (System.currentTimeMillis() / 1000);
        return output;
    }
}