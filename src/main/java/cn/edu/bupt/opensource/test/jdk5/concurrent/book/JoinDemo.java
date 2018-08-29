package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

/**
 * <p>Title: JoinDemo</p>
 * <p>Description: Join Demo </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 16:03</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class JoinDemo {

    public volatile static int i = 0;

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for(i = 0; i < 10000000; i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // join：等待线程结束
        Thread thread = new Thread(new AddThread());
        thread.start();
        thread.join();
        System.out.println(i);
    }


}
