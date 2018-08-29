package cn.edu.bupt.opensource.test.jdk4.nio.timeserver.nio;

import java.io.IOException;

/**
 * <p>Title: TimeServer</p>
 * <p>Description: 时间服务器 </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-07-09 13:03</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if(args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }


}
