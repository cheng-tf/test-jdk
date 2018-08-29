package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Title: LockTest</p>
 * <p>Description: Lock线程锁</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 21:28</p>
 *
 * @author ChengTengfei
 * @version 1.0
 */
public class LockTest {

    public static void main(String[] args) {
        new LockTest().init();
    }

    private void init() {
        final Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("chengtf");
                }

            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output2("qiaohf");
                }

            }
        }).start();
    }


    static class Outputer{

        Lock lock = new ReentrantLock();

        public void output(String name){
            int len = name.length();
            lock.lock();
            try{
                for(int i = 0; i < len; i++){
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            } finally {
                lock.unlock();
            }
        }

        public synchronized void output2(String name){
            int len = name.length();
            for(int i = 0; i < len; i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        public static synchronized void output3(String name){
            int len = name.length();
            for(int i = 0; i < len; i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }

}
