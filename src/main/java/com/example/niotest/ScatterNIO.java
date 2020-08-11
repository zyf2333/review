package com.example.niotest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author zyf
 * @Description
 * @ClassName ScatterNIO
 * @Date 2020/7/26 18:27
 **/
public class ScatterNIO {
    public static void main(String[] args) {
//        gather();
        scatter();
    }

    public static void gather() {
        ByteBuffer header = ByteBuffer.allocate(10);
        ByteBuffer body = ByteBuffer.allocate(10);
        byte[] b1 = {'0', '1'};
        byte[] b2 = {'2', '3'};
        header.put(b1);
        body.put(b2);
        header.flip();
        body.flip();
        ByteBuffer[] buffs = {header, body};
        try {
            RandomAccessFile os = new RandomAccessFile("src/scattingAndGather.txt", "rw");
//            FileOutputStream os = new FileOutputStream("src/scattingAndGather.txt");
            FileChannel channel = os.getChannel();
            channel.write(buffs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void scatter(){
        ByteBuffer header = ByteBuffer.allocate(2);
        ByteBuffer body = ByteBuffer.allocate(2);
        ByteBuffer[] buffs = {header, body};
        try {
            RandomAccessFile os = new RandomAccessFile("src/scattingAndGather.txt", "rw");
            FileChannel channel = os.getChannel();
            long read = channel.read(buffs);
            System.out.println(read);
            while (read != -1) {
                for (ByteBuffer buff : buffs) {
                    buff.flip();
                    while (buff.hasRemaining()) {
                        System.out.print((char) buff.get());
                    }
                    buff.compact();
                }
                read = channel.read(buffs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
