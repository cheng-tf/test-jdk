package cn.edu.bupt.opensource.test.jdk4.nio.timeserver.nio;

/**
 * <p>Title: TimeClient</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-07-09 14:13</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        if(args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        new Thread(new TimeClientHandle("127.0.0.1", port)).start();


    }

}
