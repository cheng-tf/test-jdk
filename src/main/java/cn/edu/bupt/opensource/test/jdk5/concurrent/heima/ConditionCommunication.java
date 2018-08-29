package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Title: ConditionCommunication</p>
 * <p>Description: Condition 线程通信 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 22:00</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ConditionCommunication {

    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 50; i++){
                    business.sub(i);
                }
            }
        }
        ).start();

        for(int i = 1; i <= 50; i++){
            business.main(i);
        }
    }



    static class Business {

        // 线程锁
        Lock lock = new ReentrantLock();

        Condition condition = lock.newCondition();

        private boolean bShouldSub = true;

        public void sub(int i) {
            lock.lock();
            try {
                while (!bShouldSub) {
                    try {
                        condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 1; j <= 10; j++) {
                    System.out.println("sub thread sequence of " + j + ",loop of " + i);
                }
                bShouldSub = false;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }

        public void main(int i) {
            lock.lock();
            try {
                while (bShouldSub) {
                    try {
                        condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 1; j <= 100; j++) {
                    System.out.println("main thread sequence of " + j + ",loop of " + i);
                }
                bShouldSub = true;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }


}
