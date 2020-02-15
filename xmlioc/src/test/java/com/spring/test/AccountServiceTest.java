package com.spring.test;

import com.spring.domain.Account;
import com.spring.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.domain.Account;
import spring.service.IAccountService;

import java.util.List;

/**
 * RunWith:
 * RunWith就是一个运行器
 * RunWith(SpringJUnit4ClassRunner.class),让测试运行于Spring测试环境
 */

/**
 * ContextConfiguration:
 * ContextConfiguration 使用注解引入多个配置文件
 * 单个文件
 * ContextConfiguration(Locations="../applicationContext.xml")
 * ContextConfiguration(classes = SimpleConfiguration.class)
 * 多个文件时，可用{}
 * ContextConfiguration(locations = { "classpath*:/spring1.xml", "classpath*:/spring2.xml" })
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService service;

    @Test
    public void testFindAll() {

        List<Account> allAccount = service.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }
}
