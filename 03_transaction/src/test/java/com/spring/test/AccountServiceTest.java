package com.spring.test;

import com.spring.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName AccountServiceTest
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/6 16:02
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:account_transaction.xml")
public class AccountServiceTest {

    @Autowired
    @Qualifier("proxyAccountService")
    private AccountService as;

    @Test
    public void testTransfer() {
        as.transfer("aaa", "bbb", 100f);
    }
}
