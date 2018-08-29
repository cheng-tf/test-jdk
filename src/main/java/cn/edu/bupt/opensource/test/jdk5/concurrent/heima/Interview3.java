package cn.edu.bupt.opensource.test.jdk5.concurrent.heima;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>Title: Interview3</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 18:18</p>
 * @author ChengTengfei
 * @version 1.0
 */
//不能改动此Interview3类
public class Interview3 extends Thread{

    private TestDo2 testDo;
    private String key;
    private String value;

    public Interview3(String key,String key2,String value){
        this.testDo = TestDo2.getInstance();
			/*常量"1"和"1"是同一个对象，下面这行代码就是要用"1"+""的方式产生新的对象，
			以实现内容没有改变，仍然相等（都还为"1"），但对象却不再是同一个的效果*/
        this.key = key+key2;
        this.value = value;
    }

    public static void main(String[] args) throws InterruptedException{
        Interview3 a = new Interview3("1","","1");
        Interview3 b = new Interview3("1","","2");
        Interview3 c = new Interview3("3","","3");
        Interview3 d = new Interview3("4","","4");
        System.out.println("begin:"+(System.currentTimeMillis()/1000));
        a.start();
        b.start();
        c.start();
        d.start();
    }

    public void run(){
        testDo.doSome(key, value);
    }
}


class TestDo2 {

   private TestDo2() {}

   private static TestDo2 _instance = new TestDo2();

   public static TestDo2 getInstance() {
       return _instance;
   }

   private CopyOnWriteArrayList<Object> keys = new CopyOnWriteArrayList<>();

   public void doSome(Object key, String value) {

       Object o = key;
       if(!keys.contains(o)) {
           keys.add(o);
       } else {
           for(Object oo : keys) {
               if(oo.equals(o)) {
                   o = oo;
               }
           }
       }

       // 以大括号内的是需要局部同步的代码，不能改动!
       synchronized (o){
           try {
               Thread.sleep(1000);
               System.out.println(key+":"+value + ":" + (System.currentTimeMillis() / 1000));
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   }

}

