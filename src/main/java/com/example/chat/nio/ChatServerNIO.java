package com.example.chat.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Author zyf
 * @Description
 * @ClassName ChatServerNIO
 * @Date 2020/7/25 10:55
 **/
public class ChatServerNIO {

    private static final int BUF_SIZE = 1024;
    private static final int PORT = 9090;
    private static final int TIMEOUT = 3000;

    public static void main(String[] args) {
        selector();
    }

    public static void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);
        sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
    }

    public static void handleRead(SelectionKey key,SocketChannel sc) throws IOException {
        ByteBuffer buf = (ByteBuffer) key.attachment();

        long bytesRead = sc.read(buf);
        while (bytesRead > 0) {
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            System.out.println();
            buf.clear();
            bytesRead = sc.read(buf);
        }
        if (bytesRead == -1) {
            sc.close();
        }


    }

    public static void handleWrite(SelectionKey key,SocketChannel sc) throws IOException {
        ByteBuffer buf = (ByteBuffer) key.attachment();
        buf.flip();
        while (buf.hasRemaining()) {
            sc.write(buf);
        }
        buf.compact();
    }

    public static void selector() {
        Selector selector = null;
        ServerSocketChannel ssc = null;
        try {
            selector = Selector.open();
            ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(PORT));
            ssc.configureBlocking(false);
            ssc.register(selector, SelectionKey.OP_ACCEPT);
//            register.interestOps(SelectionKey.OP_CONNECT);
            while (true) {
                //查询selector是否有要处理的channel
                System.out.println("==");
                //select返回你所感兴趣的事件（如连接、接受、读或写）已经准备就绪的那些通道
                int select = selector.select(TIMEOUT);
                System.out.println(select);
//                if (selector.select(TIMEOUT) == 0) {
                if (select == 0) {
//                    System.out.println("无就绪Channel");
                    continue;
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                //遍历channel
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    SocketChannel sc = null;
                    try {
                        if (key.isAcceptable()) {//准备好接受客户端
                            handleAccept(key);
                        }
                        if (key.isReadable()) {//读就绪
                            sc = (SocketChannel) key.channel();
                            handleRead(key,sc);
                        }
                        if (key.isWritable() && key.isValid()) {//写就绪
                            sc = (SocketChannel) key.channel();
                            handleWrite(key,sc);
                        }
                        if (key.isConnectable()) {//连接就绪
                            System.out.println("isConnectable = true");
                        }
                        iter.remove();
                    }catch (IOException e) {
                        System.out.println("连接断开。。。");
                        key.cancel();
                        sc.socket().close();
                        sc.close();
                    }
                }
            }
            /*
            //非selector管理方式
            ssc.configureBlocking(false);
            while (true){
                SocketChannel client = ssc.accept();
                if(client!=null){//如果是非阻塞状态，没有连接会直接返回null
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    long bytesRead = client.read(buf);
                    while (bytesRead > 0) {
                        buf.flip();
                        while (buf.hasRemaining()) {
                            System.out.print((char) buf.get());
                        }
                        System.out.println();
                        buf.clear();
                        bytesRead = client.read(buf);
                    }
                    if (bytesRead == -1) {
                        client.close();
                    }
                }
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (selector != null) {
                    selector.close();
                }
                if (ssc != null) {
                    ssc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
