package cn.edu.bupt.opensource.test.jdk4.nio.timeserver.false_aio;

import cn.edu.bupt.opensource.test.jdk4.nio.timeserver.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("时间服务器在端口: " + port + "启动。");
            Socket socket = null;
            TimeServerHandlerExecutorPool pool = new TimeServerHandlerExecutorPool(50, 10000);
            while (true) {
                socket = server.accept();// 阻塞
                pool.execute(new TimeServerHandler(socket));
            }
        } finally {
            if(server != null) {
                System.out.println("时间服务器关闭。");
                server.close();
                server = null;
            }
        }


    }


}
