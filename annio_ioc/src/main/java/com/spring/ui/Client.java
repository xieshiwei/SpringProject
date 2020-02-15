package com.spring.ui;

import com.spring.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Client
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/4 17:35
 **/
public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_anno_ioc.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.saveAccount();
        context.close();
    }
}
