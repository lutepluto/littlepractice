package jiecao.chat.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.ArrayList;
import java.util.List;

/**
 * 启动 netty 服务，监听指定 端口
 * TODO 单例模式，后续修改为spring注入
 * @author bikao
 */
public class WebSocketServer {
	private volatile static WebSocketServer websocketServer; 

	/**
	 * TODO netty监听端口，后续改为配置文件写入
	 */
    private final int port = 8080;
    
    private WebSocketServer() throws Exception
    {
    	run();
    }
    
    //双重检查加锁
    public static WebSocketServer getInstance() throws Exception {
    	if (websocketServer == null) {
    		synchronized (WebSocketServer.class) {
    			if (websocketServer == null) {
    				websocketServer = new WebSocketServer();
    			}
    		}
    	}
    	return websocketServer;
    }
    

    private void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
             .channel(NioServerSocketChannel.class)
             .childHandler(new WebSocketServerInitializer());

            Channel ch = b.bind(port).sync().channel();
            System.out.println("Web socket server started at port " + port + '.');
            System.out.println("Open your browser and navigate to http://localhost:" + port + '/');

            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new WebSocketServer().getInstance().run();
    }
}
