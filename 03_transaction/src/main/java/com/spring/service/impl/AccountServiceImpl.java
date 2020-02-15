package com.spring.service.impl;

import com.spring.dao.AccountDao;
import com.spring.domain.Account;
import com.spring.service.AccountService;

import java.util.List;

/**
 * @ClassName AccountServiceImpl
 * @Author 萌琪琪爸爸
 * @Description //
 * 账户的业务层实现
 * 事务控制应该都是在业务层
 * @Date 2020/1/6 13:53
 **/
public class AccountServiceImpl implements AccountService {

    public AccountDao accountDao;

    /**
     * 查找
     *
     * @return
     */
    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    /**
     * 通过ID查找用户
     *
     * @param accountId
     * @return
     */
    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    /**
     * 保存用户
     *
     * @param account
     */
    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    /**
     * 更新用户
     *
     * @param account
     */
    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    /**
     * 删除用户
     *
     * @param acccountId
     */
    @Override
    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount(acccountId);
    }

    /**
     * 转账实现
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer...");
        //2.执行操作
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney() + money);
        //2.5更新转出账户
        accountDao.updateAccount(source);
        //2.6更新转入账户
        accountDao.updateAccount(target);
    }
}
