package com.example.chat.bio;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author zyf
 * @Description
 * @ClassName Client
 * @Date 2020/7/24 23:37
 **/
public class Client {
    private static final String HOST_NAME = "127.0.0.1";

    private static final int PORT = 9090;

    public static void main(String[] args) throws Exception{
        Socket client = new Socket(HOST_NAME, PORT);
        Scanner scan = new Scanner(client.getInputStream());
        scan.useDelimiter("\n");
        PrintStream out = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while (flag){
            String inputData = InputUtil.getString("请输入要发送的内容：").trim();
            out.println(inputData);
            if (scan.hasNext()){
                String str = scan.next();
                System.out.println(str);
            }
            if ("bye".equalsIgnoreCase(inputData)){
                flag = false;
            }
        }
        client.close();
    }
}
