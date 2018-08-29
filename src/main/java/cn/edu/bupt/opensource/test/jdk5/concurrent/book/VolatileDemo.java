package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

/**
 * <p>Title: VolatileDemo</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 16:10</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class VolatileDemo {

    private static volatile boolean ready = false;

    private static int number;

    private static class ReaderThread implements Runnable {
        @Override
        public void run() {
            while (!ready);
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // volatile：保证数据的可见性与有序性
        new Thread(new ReaderThread()).start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        Thread.sleep(1000);
    }


}
