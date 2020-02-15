package com.spring.test;

import com.spring.domain.Account;
import com.spring.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName AccountServiceTest
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/5 11:49
 **/
public class AccountServiceTest {

    @Test
    public void findAll() {
        //获取配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("account_anno_ioc.xml");

        //得到业务对象
        AccountService accountService = context.getBean("accountService", AccountService.class);

        //执行业务逻辑
        List<Account> allAccount = accountService.findAllAccount();

        for (Account account : allAccount) {
            System.out.println(account.getName());
        }
    }
}
