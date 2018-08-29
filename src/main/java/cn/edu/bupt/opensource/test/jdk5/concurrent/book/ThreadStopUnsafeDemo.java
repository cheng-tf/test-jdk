package cn.edu.bupt.opensource.test.jdk5.concurrent.book;

/**
 * <p>Title: ThreadStopUnsafeDemo</p>
 * <p>Description: 终止线程（不安全）:stop立即终止线程，并释放锁，破坏了数据的一致性 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-06-01 15:36</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class ThreadStopUnsafeDemo {

    private static final User user = new User();

    public static class User {
        private int id;
        private String name;

        User() {
            id = 0;
            name = "0";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }

    public static class ChangeObjectThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    int value = (int) System.currentTimeMillis() / 1000;
                    user.setId(value);
                    // do something else
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(value));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if(user.getId() != Integer.parseInt(user.getName())) {
                        System.out.println(user.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ReadObjectThread()).start();
        while (true) {
            Thread thread = new Thread(new ChangeObjectThread());
            thread.start();
            Thread.sleep(150);
            thread.stop();
        }
    }


}
