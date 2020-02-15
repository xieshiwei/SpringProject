package com.spring.service;

import com.spring.domain.Account;

import java.util.List;

/**
 * @ClassName IAccountService
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/12/30 13:54
 **/
public interface IAccountService {

    /**
     * 查询所有账户信息
     *
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 通过ID查询账户
     *
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存账户
     *
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     *
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     *
     * @param id
     */
    void deleteAccount(Integer id);

}
