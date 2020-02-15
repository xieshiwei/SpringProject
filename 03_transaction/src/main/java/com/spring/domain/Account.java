package com.spring.domain;

import java.io.Serializable;

/**
 * @ClassName Account
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/6 12:29
 **/
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Float money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

}
