package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

/**
 * <p>Title: DaemonDemo</p>
 * <p>Description: 守护线程Demo </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 16:15</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class DaemonDemo {

    public static class DaemonT implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("I am alive.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DaemonT());
        // 设置thread为守护线程
        // 当仅存有守护线程时，JVM自然退出
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2000);
    }

}
