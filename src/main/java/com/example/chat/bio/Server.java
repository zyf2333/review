package com.example.chat.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @Author zyf
 * @Description
 * @ClassName Server
 * @Date 2020/7/24 23:31
 **/
public class Server {

    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(PORT);
        System.out.println("服务端已经启动，监听端口为：" + PORT);
        boolean flag = true;
        ExecutorService executorService =
                new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                        60L, TimeUnit.SECONDS,
                        new SynchronousQueue<>());
        while (flag) {
            System.out.println(socket.isClosed());
            if (!socket.isClosed()) {
                Socket client = socket.accept();
                executorService.submit(new EchoClientHandler(client));
            }
        }
        executorService.shutdown();
        socket.close();
        return;
    }

    private static class EchoClientHandler implements Runnable {
        private Socket client;
        private PrintStream out;
        private boolean flag = true;

        public EchoClientHandler(Socket client) {
            this.client = client;
            try {
                this.out = new PrintStream(this.client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            System.out.println("客户端已连接：" + client.getInetAddress());
            int recvMsgSize;
            byte[] recvBuf = new byte[1024];
            InputStream in = null;
            try {
                in = client.getInputStream();
                while (!client.isClosed()&&(recvMsgSize = in.read(recvBuf)) != -1) {
                    byte[] temp = new byte[recvMsgSize];
                    System.arraycopy(recvBuf, 0, temp, 0, recvMsgSize);
                    System.out.println(new String(temp));
                    out.println("服务器："+new String(temp));
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                    this.out.close();
                    this.client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
