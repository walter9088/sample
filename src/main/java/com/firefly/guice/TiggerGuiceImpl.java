package com.firefly.guice;

/**
 * 类TiggerGuiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月3日 上午4:11:59
 */
public class TiggerGuiceImpl implements AnimalGuice {

    @Override
    public void run() {
        System.out.println("this is tigger run!");
    }

}
