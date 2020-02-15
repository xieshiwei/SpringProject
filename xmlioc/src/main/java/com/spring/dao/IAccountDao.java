package com.spring.dao;

import com.spring.domain.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有
     *
     * @return
     */
    List<Account> finalAllAccount();

    /**
     * 查询第一个
     *
     * @param accountId
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
     * @param accountId
     */
    void deleteAccount(Integer accountId);
}
