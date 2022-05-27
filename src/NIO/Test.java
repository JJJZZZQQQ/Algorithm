package NIO;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws IOException {
        // create Selector
        Selector selector = Selector.open();

        //register
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_ACCEPT);


        // get events
        while (true) {
            //monitoring -- num is events size
            int num = selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    // ...
                } else if (key.isReadable()) {
                    // ...
                }
                keyIterator.remove();
            }
        }
    }
}
