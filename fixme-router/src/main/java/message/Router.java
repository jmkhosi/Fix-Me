package message;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

public class Router implements Runnable {

    String host;
    int port;

    Router(String host, int port) {
        this.host = host;
        this.port = port;
    }
    @Override
    public void run() {
        try {

            AsynchronousServerSocketChannel server = null;
            server = AsynchronousServerSocketChannel.open();
            InetSocketAddress sAddr = new InetSocketAddress(host, port);
            server.bind(sAddr);
            System.out.format("Router is listening at %s%n ", sAddr);
            Attachment attach = new Attachment();
            attach.server = server;
            server.accept(attach, new ConnectionHandler());

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
