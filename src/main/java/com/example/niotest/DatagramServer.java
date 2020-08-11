package com.example.niotest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author zyf
 * @Description
 * @ClassName DatagramChannelTest
 * @Date 2020/7/26 19:01
 **/
public class DatagramServer {
    public static void main(String[] args) {
        reveive();
    }

    public static void reveive() {
        DatagramChannel channel = null;
        try {
            Selector selector = Selector.open();
            channel = DatagramChannel.open();
            channel.configureBlocking(false);
            channel.socket().bind(new InetSocketAddress(8888));

            channel.register(selector, SelectionKey.OP_READ);

            while (true) {
                if (selector.select(3000) == 0) {
                    continue;
                }
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                if (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    if (next.isValid() && next.isReadable()) {
                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        buf.clear();
                        DatagramChannel datagramChannel = (DatagramChannel) next.channel();
                        datagramChannel.receive(buf);
                        buf.flip();
                        while (buf.hasRemaining()) {
                            System.out.print((char) buf.get());
                        }
                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (channel != null) {
                    channel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
