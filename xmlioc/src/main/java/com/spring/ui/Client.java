package com.spring.ui;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.service.IAccountService;

/**
 * @ClassName Client
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/12/30 13:53
 **/
public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService service = (IAccountService) ac.getBean("accountService");
        IAccountService service2 = (IAccountService) ac.getBean("accountService");
        /**
         * 用来测试bean加载容器和bean注册
         */
//        service.saveAccount();
//        ac.close();

        /**
         * 测试Scope
         * accountService bean因为指定了Scope=trototype多例，所以两个实例不相等
         */
        System.out.println(service == service2);
    }
}
