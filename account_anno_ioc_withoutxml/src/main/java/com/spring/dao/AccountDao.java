package com.spring.dao;

import com.spring.domain.Account;

import java.util.List;

/**
 * @ClassName AccountDao
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/5 16:04
 **/
public interface AccountDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     *
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     *
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     *
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     *
     * @param acccountId
     */
    void deleteAccount(Integer accountId);
}
