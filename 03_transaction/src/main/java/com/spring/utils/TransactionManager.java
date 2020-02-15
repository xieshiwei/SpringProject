package com.spring.utils;

import java.sql.SQLException;

/**
 * @ClassName TransactionManager
 * @Author 萌琪琪爸爸
 * @Description //
 * 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 * @Date 2020/1/6 14:43
 **/
public class TransactionManager {

    /**
     * 通过ThreadLocal来实现的一个数据库连接工具
     */
    private ConnectionUtils connectionUtils;

    /**
     * 通过xml注入需要的Set方法
     *
     * @param connectionUtils
     */
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction() {
        try {

            /**
             * 自动或手动提交设置
             * true：如果连接处于自动提交模式，所有sql语句将作为个人执行和提交
             * false：否则将sql语句分组为通过调用 commit 或 rollback 其中一个终止
             */
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放事务
     */
    public void release() {
        try {
            //关闭事务的，返回到连接池中
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
