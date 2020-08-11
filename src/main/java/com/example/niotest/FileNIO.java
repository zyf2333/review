package com.example.niotest;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author zyf
 * @Description
 * @ClassName FileNIO
 * @Date 2020/7/25 11:15
 **/
public class FileNIO {

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("src/nio.txt", "rw");
            FileChannel fileChannel = aFile.getChannel();
//            FileChannel fileChannel = new FileInputStream("src/nomal_io.txt").getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1);
            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);
            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }

            FileOutputStream fos = new FileOutputStream("src/nio.txt", true);
            FileChannel fileChannel1 = fos.getChannel();
//            fileChannel1.truncate(1); //截断
//            fileChannel1.transferFrom(new FileInputStream("src/nomal_io.txt").getChannel(),0,100);
            fileChannel1.write(buf);
//            fileChannel1.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
