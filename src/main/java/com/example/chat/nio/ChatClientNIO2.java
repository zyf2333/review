package com.example.chat.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @Author zyf
 * @Description
 * @ClassName ChatClientNIO
 * @Date 2020/7/25 10:55
 **/
public class ChatClientNIO2 {

    public static void main(String[] args) {
        client();
    }

    public static void client() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);//配置是否阻塞
            socketChannel.connect(
                    new InetSocketAddress("127.0.0.1", 9090));
            if (socketChannel.finishConnect()) {
                int i = 0;
//                注意SocketChannel.write()方法的调用是在一个while循环中的。
//                write()方法无法保证能写多少字节到SocketChannel。
//                所以，我们重复调用write()直到Buffer没有要写的字节为止。
//                非阻塞模式下,read()方法在尚未读取到任何数据时可能就返回了。
//                所以需要关注它的int返回值，它会告诉你读取了多少字节。
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    String info = "2I'm " + i++ + "-th information from client";
                    buffer.clear();//清空缓存
                    buffer.put(info.getBytes());//写入数据
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        System.out.println(new String(buffer.array()));
                        socketChannel.write(buffer);
                    }
//                    while(true){
//                        socketChannel.read(readBuffer);
//                        System.out.println(new String(readBuffer.array()));
//                        readBuffer.clear();
//                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (socketChannel != null) {
                    socketChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
