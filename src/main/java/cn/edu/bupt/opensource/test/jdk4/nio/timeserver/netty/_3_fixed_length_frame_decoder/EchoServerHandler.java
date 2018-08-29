package cn.edu.bupt.opensource.test.jdk4.nio.timeserver.netty._3_fixed_length_frame_decoder;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * <p>Title: TimeServerHandler</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-07-09 15:10</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class EchoServerHandler extends ChannelHandlerAdapter {

    private int counter;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("接收的客户端消息为：接收的命令为：[" + msg + "]。");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
