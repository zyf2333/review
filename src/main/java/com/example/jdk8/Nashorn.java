package com.example.jdk8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @Author zyf
 * @Description
 * @ClassName Nashorn
 * @Date 2020/7/28 20:59
 **/
public class Nashorn {
    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String id = "1";
        Integer result = null;
        try {
            Object eval = nashorn.eval("function checkIdCard(idcard) { var regIdCard = /(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)/; if (!regIdCard.test(idcard)) { errorMsg = '身份证号填写有误'; return false; } else { return true; } } checkIdCard(" + id + ")");
            System.out.println(eval);

        } catch (ScriptException e) {
            System.out.println("执行脚本错误: " + e.getMessage());
        }
        System.out.println(result.toString());
    }
}
