package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

/**
 * <p>Title: ThreadDemo</p>
 * <p>Description: 新建线程Demo </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 15:32</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ThreadCreateDemo implements Runnable{

    @Override
    public void run() {
        System.out.println("Oh, I am Runnable!");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadCreateDemo());
        thread.start();
    }

}
