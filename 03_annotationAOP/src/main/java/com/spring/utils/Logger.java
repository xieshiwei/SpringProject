package com.spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName Logger
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/16 10:37
 **/
@Component("logger")
@Aspect//表示当前类是一个切面
public class Logger {

    /**
     * AOP表达式
     */
    @Pointcut("execution(* com.spring.service.impl.*.*(..))")
    private void pt1() {
    }


    /**
     * 环绕通知
     * 问题：
     * 当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     * 通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。
     * 解决：
     * Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     * spring中的环绕通知：
     * 它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     *
     * @param print
     * @return
     */
    @Around("pt1()")
    public Object aroundPringLog(ProceedingJoinPoint pjp) {
        Object result = null;
        try {
            //得到方法执行所需要的参数
            Object[] args = pjp.getArgs();
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。前置");
            //明确调用业务层方法（切入点方法）
            result = pjp.proceed(args);
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。后置");
            return result;
        } catch (Throwable e) {
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。异常");
            throw new RuntimeException(e);
        } finally {
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。最终");
        }
    }

}
