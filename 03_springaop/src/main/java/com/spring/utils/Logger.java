package com.spring.utils;

/**
 * @ClassName Logger
 * @Author 萌琪琪爸爸
 * @Description //用于记录日志的工具类，里面提供了公共的代码
 * @Date 2020/1/7 19:55
 **/
public class Logger {

    /**
     * 用于打印日志：计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void printLog() {
        System.out.println("Logger类中的pringlog方法");
    }
}
