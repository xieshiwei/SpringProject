package com.spring.service;

/**
 * @ClassName AccountService
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/16 10:34
 **/
public interface AccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     *
     * @param i
     */
    void updateAccount(int i);

    /**
     * 删除账户
     *
     * @return
     */
    int deleteAccount();

}
