package com.spring.factory;

import com.spring.service.AccountService;
import com.spring.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName BeanFactory
 * @Author 萌琪琪爸爸
 * @Description //
 * 创建Service的代理工厂
 * @Date 2020/1/7 13:30
 **/
public class BeanFactory {

    /**
     * 服务实现类
     */
    private AccountService accountService;

    /**
     * 事务方法
     */
    private TransactionManager txManager;

    /**
     * 用于注入服务实现方法
     *
     * @param accountService
     */
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 用于注入事务工具类
     *
     * @param txManager
     */
    public final void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     * 获取Service代理对象
     *
     * @return
     */
    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务处理
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("test".equals(method.getName())) {
                            return method.invoke(accountService, args);
                        }
                        Object result = null;

                        try {
                            //1.开启事务
                            txManager.beginTransaction();
                            //2.执行操作
                            result = method.invoke(accountService, args);
                            //3.提交事务
                            txManager.commit();
                            //4.返回结果
                            return result;
                        } catch (Exception e) {
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            txManager.release();
                        }

                    }
                });
    }
}
