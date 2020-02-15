package com.spring.service.impl;

import com.spring.service.AccountService;

/**
 * @ClassName AccountServiceImpl
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/7 19:52
 **/
public class AccountServiceImpl implements AccountService {

    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
    }


    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新" + i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
