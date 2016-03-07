package com.firefly.guice;

import com.google.inject.Inject;

/**
 * 类TiggerGuiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月3日 上午4:11:59
 */
public class TiggerGuiceImpl implements AnimalGuice {

    @Inject
    private Fly fly;

    @Override
    public void run() {
        if (fly.flyAction()) {
            System.out.println("this is can fly tigger!");
        } else {
            System.out.println("this is not fly tigger!");
        }

    }

}
