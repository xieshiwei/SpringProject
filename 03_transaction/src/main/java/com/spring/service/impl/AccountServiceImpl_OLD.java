package com.spring.service.impl;

import com.spring.dao.AccountDao;
import com.spring.domain.Account;
import com.spring.service.AccountService;
import com.spring.utils.TransactionManager;

import java.util.List;

/**
 * @ClassName AccountServiceImpl
 * @Author 萌琪琪爸爸
 * @Description //
 * 账户的业务层实现
 * 事务控制应该都是在业务层
 * @Date 2020/1/6 13:53
 **/
public class AccountServiceImpl_OLD implements AccountService {

    public AccountDao accountDao;
    private TransactionManager txManager;

    /**
     * 查找
     *
     * @return
     */
    @Override
    public List<Account> findAllAccount() {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;
        } catch (Exception e) {
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            txManager.release();
        }
    }

    /**
     * 通过ID查找用户
     *
     * @param accountId
     * @return
     */
    @Override
    public Account findAccountById(Integer accountId) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            Account account = accountDao.findAccountById(accountId);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return account;
        } catch (Exception e) {
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            txManager.release();
        }
    }

    /**
     * 保存用户
     *
     * @param account
     */
    @Override
    public void saveAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManager.commit();
        } catch (Exception e) {
            //4.回滚操作
            txManager.rollback();
        } finally {
            //5.释放连接
            txManager.release();
        }
    }

    /**
     * 更新用户
     *
     * @param account
     */
    @Override
    public void updateAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            txManager.commit();
        } catch (Exception e) {
            //4.回滚操作
            txManager.rollback();
        } finally {
            //5.释放连接
            txManager.release();
        }
    }

    /**
     * 删除用户
     *
     * @param acccountId
     */
    @Override
    public void deleteAccount(Integer acccountId) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(acccountId);
            //3.提交事务
            txManager.commit();
        } catch (Exception e) {
            //4.回滚操作
            txManager.rollback();
        } finally {
            //5.释放连接
            txManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //1.开启事务
            txManager.beginTransaction();
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

            int i = 1 / 0;

            //2.6更新转入账户
            accountDao.updateAccount(target);
            //3.提交事务
            txManager.commit();

        } catch (Exception e) {
            //4.回滚操作
            txManager.rollback();
            e.printStackTrace();
        } finally {
            //5.释放连接
            txManager.release();
        }
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }
}
