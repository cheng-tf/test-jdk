package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

/**
 * <p>Title: ThreadInterruptDemo</p>
 * <p>Description: 线程中断Demo </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 15:48</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ThreadInterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted When Sleep");
                        // 设置中断状态
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

}
