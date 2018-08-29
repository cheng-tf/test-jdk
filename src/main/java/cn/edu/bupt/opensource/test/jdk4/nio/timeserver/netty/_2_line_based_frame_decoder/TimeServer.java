package cn.edu.bupt.opensource.test.jdk4.nio.timeserver.netty._2_line_based_frame_decoder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * <p>Title: TimeServer</p>
 * <p>Description: 时间服务器（基于Netty） </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-07-09 15:02</p>
 * @author ChengTengfei
 * @version 1.0
 */
public class TimeServer {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if(args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        new TimeServer().bind(port);
    }

    private void bind(int port) throws Exception {
        // NIO-Reactor线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();//接收客户端的连接
        EventLoopGroup workerGroup = new NioEventLoopGroup();//SocketChannel的网络读写
        try {
            // NIO-辅助启动类
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHandler());
            // 绑定端口，同步等待成功
            ChannelFuture future = bootstrap.bind(port).sync();
            // 等待服务端监听端口关闭
            future.channel().closeFuture().sync();
        } finally {
            // 释放线程组资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        protected void initChannel(SocketChannel socketChannel) throws Exception {
            // 按行切换的文本解码器
            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));//解决TCP粘包/拆包问题
            socketChannel.pipeline().addLast(new StringDecoder());//对象--->字符串
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }

}
