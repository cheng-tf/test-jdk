package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <p>Title: ThreadScopeShareData</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 20:37</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ThreadScopeShareData {

    private static int data = 0;

    private static Map<Thread, Integer> threadData = new HashMap<>();

    static class A{
        public void get(){
            System.out.println("A from " + Thread.currentThread().getName() + " get data :" + threadData.get(Thread.currentThread()));
        }
    }

    static class B{
        public void get(){
            System.out.println("B from " + Thread.currentThread().getName() + " get data :" + threadData.get(Thread.currentThread()));
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 2; i++){
            new Thread(new Runnable(){
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data :" + data);
                    threadData.put(Thread.currentThread(), data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

}
