package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

import java.util.Random;

/**
 * <p>Title: ThreadLocalTest</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-31 20:43</p>
 *
 * @author ChengTengfei
 * @version 1.0
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();

    public static void main(String[] args) {
        for(int i = 0; i < 2; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data :" + data);
                    x.set(data);
                    MyThreadScopeData.getThreadInstance().setName("name" + data);
                    MyThreadScopeData.getThreadInstance().setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A{
        public void get() {
            System.out.println("A from " + Thread.currentThread().getName() + " get data :" + x.get());
            MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
            System.out.println("A from " + Thread.currentThread().getName()
                    + " getMyData: " + myData.getName() + "," + myData.getAge());
        }
    }

    static class B{
        public void get() {
            System.out.println("B from " + Thread.currentThread().getName() + " get data :" + x.get());
            MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
            System.out.println("B from " + Thread.currentThread().getName()
                    + " getMyData: " + myData.getName() + "," + myData.getAge());
        }
    }

}

class MyThreadScopeData{

    private MyThreadScopeData(){
    }

    public static /*synchronized*/ MyThreadScopeData getThreadInstance(){
        MyThreadScopeData instance = map.get();
        if(instance == null){
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }
    //private static MyThreadScopeData instance = null;//new MyThreadScopeData();
    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();

    private String name;

    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
