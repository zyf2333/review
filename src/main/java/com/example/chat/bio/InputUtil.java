package com.example.chat.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author zyf
 * @Description
 * @ClassName InputUtil
 * @Date 2020/7/24 23:38
 **/
public class InputUtil {
    private static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));

    private InputUtil(){
    }

    public static String getString(String prompt){
        boolean flag = true;    //数据接受标记
        String str = null;
        while (flag){
            System.out.println(prompt);
            try {
                str = KEYBOARD_INPUT.readLine();    // 读取一行数据
                if(str == null || "".equals(str)){
                    System.out.println("数据输入错误，不允许为空！");
                }else {
                    flag = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str;
    }
}
