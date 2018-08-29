package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

/**
 * <p>Title: TraditionalThreadSynchronized</p>
 * <p>Description: 线程同步</p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-30 23:59</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class TraditionalThreadSynchronized {

    public static void main(String[] args) {
        new TraditionalThreadSynchronized().init();
    }

    private void init() {
        final Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("chengtf");
                }

            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output2("qiaohf");
                }

            }
        }).start();
    }


    static class Outputer{

        public void output(String name){
            int len = name.length();
            synchronized (Outputer.class){
                for(int i = 0; i < len; i++){
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }

        public synchronized void output2(String name){
            int len = name.length();
            for(int i = 0; i < len; i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        public static synchronized void output3(String name){
            int len = name.length();
            for(int i = 0; i < len; i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }

}
