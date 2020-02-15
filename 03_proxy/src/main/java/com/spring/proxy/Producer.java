package com.spring.proxy;

/**
 * @ClassName Producer
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * 生产者
 * @Date 2020/1/6 20:12
 **/
public class Producer implements IProducer {

    /**
     * 销售
     *
     * @param money
     */
    @Override
    public void saleProduct(float money) {
        System.out.println("销售产品，并拿到钱：" + money);
    }

    /**
     * 售后
     *
     * @param money
     */
    @Override
    public void afterService(float money) {
        System.out.println("售后服务，并拿到钱：" + money);
    }
}
