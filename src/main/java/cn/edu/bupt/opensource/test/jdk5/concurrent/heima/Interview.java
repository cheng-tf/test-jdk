package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <p>Title: Interview</p>
 * <p>Description: 空中网 笔试题1 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 23:47</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class Interview {

    public static void main(String[] args) {

        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(16);

        for(int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String log = null;
                        try {
                            log = queue.take();
                            parseLog(log);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        System.out.println("begin:" + (System.currentTimeMillis() / 1000));
         // 模拟处理16行日志，下面的代码产生了16个日志对象，当前代码需要运行16秒才能打印完这些日志。
		 // 修改程序代码，开四个线程让这16个对象在4秒钟打完。
        for (int i = 0; i < 16; i++) {  //这行代码不能改动
            final String log = "" + (i + 1);//这行代码不能改动
            {
                //Interview.parseLog(log);
                try {
                    queue.put(log);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // parseLog方法内部的代码不能改动
    public static void parseLog(String log) {
        System.out.println(log + ":" + (System.currentTimeMillis() / 1000));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}