package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.AccountService;

public class AopTest {

    public static void main(String[] args) {
        // 1 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2 获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        // 3 执行方法
        as.saveAccount();
        as.updateAccount(1);
        as.deleteAccount();

    }

}
