package com.spring.test;

import com.spring.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName AopTest
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/16 10:57
 **/

public class AopTest {
    @Test
    public void testAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.saveAccount();
        accountService.deleteAccount();
    }
}
