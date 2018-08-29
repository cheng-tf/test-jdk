package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Title: ExchangerTest</p>
 * <p>Description: Exchanger测试 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 23:04</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ExchangerTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        // Exchanger：用于线程间的数据交换
        final Exchanger exchanger = new Exchanger();
        service.execute(new Runnable(){
            public void run() {
                try {
                    String data1 = "zxx";
                    System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 +"换出去");
                    Thread.sleep((long)(Math.random()*10000));
                    String data2 = (String)exchanger.exchange(data1);
                    System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + data2);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        service.execute(new Runnable(){
            public void run() {
                try {
                    String data1 = "lhm";
                    System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 +"换出去");
                    Thread.sleep((long)(Math.random()*10000));
                    String data2 = (String)exchanger.exchange(data1);
                    System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + data2);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
