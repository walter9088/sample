package com.firefly.guice;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * 类AnimalGuiceModule.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月3日 上午4:14:08
 */
public class AnimalGuiceModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(AnimalGuice.class).to(TiggerGuiceImpl.class);
    }

}
