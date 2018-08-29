package cn.edu.bupt.opensource.test.jdk4.nio.timeserver.netty._2_line_based_frame_decoder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * <p>Title: TimeServerHandler</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-07-09 15:10</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

    private int counter;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("时间服务器接收的命令为：" + body + "，计数器为：" + ++counter);
        String curTime = "QUERY TIME ORDER".equalsIgnoreCase(body)
                ? new Date(System.currentTimeMillis()).toString()
                : "BAD ORDER";
        curTime = curTime + System.getProperty("line.separator");
        ByteBuf res = Unpooled.copiedBuffer(curTime.getBytes());
        ctx.writeAndFlush(res);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
