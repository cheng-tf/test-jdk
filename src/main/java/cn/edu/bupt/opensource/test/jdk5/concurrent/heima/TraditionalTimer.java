package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <p>Title: TraditionalTimer</p>
 * <p>Description: 定时器</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-30 23:50</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class TraditionalTimer {

    private static int count = 0;

    public static void main(String[] args) {

        class MyTimerTask extends TimerTask{
            @Override
            public void run() {
                count = (count + 1) % 2;
                System.out.println("bombing!");
                new Timer().schedule(new MyTimerTask(),2000 + 2000*count);
            }
        }

        new Timer().schedule(new MyTimerTask(), 2000);

        while(true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
