package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

/**
 * <p>Title: ThreadPriorityDemo</p>
 * <p>Description: 线程优先级Demo </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 16:19</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ThreadPriorityDemo {

    public static class HighPriority implements Runnable {
        static int count = 0;
        @Override
        public void run() {
            while (true) {
                synchronized (ThreadPriorityDemo.class) {
                    count++;
                    if(count > 10000000) {
                        System.out.println("HeighPriority is complete.");
                        break;
                    }
                }
            }
        }
    }

    public static class LowPriority implements Runnable {
        static int count = 0;
        @Override
        public void run() {
            while (true) {
                synchronized (ThreadPriorityDemo.class) {
                    count++;
                    if(count > 10000000) {
                        System.out.println("LowPriority is complete.");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread high = new Thread(new HighPriority());
        Thread low = new Thread(new LowPriority());
        // 线程优先级：1 - 10
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        high.start();
        low.start();
    }


}
