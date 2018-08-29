package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Title: ThreadLocalTest</p>
 * <p>Description: 本地变量Demo </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 17:46</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ThreadLocalDemo {

    //private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    public static class ParseDate implements Runnable {
        int i = 0;
        public ParseDate(int i) {
            this.i = i;
        }
        @Override
        public void run() {
            try {
                //System.out.println(i + ": " + sdf.parse("2018-06-01 17:49:00"));
                if(threadLocal.get() == null) {
                    threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                } else {
                    System.out.println(i + ": " + threadLocal.get().parse("2018-06-01 17:49:00"));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 1000; i++) {
            threadPool.execute(new ParseDate(i));
        }
        threadPool.shutdown();
    }


}
