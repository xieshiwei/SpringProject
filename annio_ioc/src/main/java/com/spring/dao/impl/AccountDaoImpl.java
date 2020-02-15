package com.spring.dao.impl;

import com.spring.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @ClassName AccountDaoImpl
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/4 17:13
 **/
@Repository
public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存用户");
    }
}
