package NIO.单Reactor单线程;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Reactor  {

    final Selector selector;
    final ServerSocketChannel serverSocket;


    Reactor(int port) throws IOException {
        //Reactor初始化
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        //非阻塞
        serverSocket.configureBlocking(false);

        //注册
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        //attach callback object, Acceptor
        sk.attach(new Acceptor());

    }

    public void run() {
        try {
            while (true) {
                selector.select();
                Set<SelectionKey> keySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keySet.iterator();
                while (iterator.hasNext()) {
                    //Reactor负责dispatch收到的事件
                    dispatch((SelectionKey) (iterator.next()));
                }
                keySet.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void dispatch (SelectionKey key) {
        Acceptor acceptor = (Acceptor) key.attachment();
        if(acceptor != null) {
            acceptor.run();
        }
    }

    class Acceptor {

        public void run() {
            try {
                SocketChannel channel = serverSocket.accept();
                if(channel != null) {
                    new Handler(selector, channel).run();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
