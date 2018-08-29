package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

/**
 * <p>Title: TraditionalThread</p>
 * <p>Description: 创建线程：继承Thread类、实现Runnable接口</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-30 23:35</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class TraditionalThread {


    public static void main(String[] args){

        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1:" + Thread.currentThread().getName());
                    System.out.println("2:" + this.getName());
                }
            }
        };
        thread.start();

        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1:" + Thread.currentThread().getName());
                }
            }
        });
        thread2.start();
    }

}
