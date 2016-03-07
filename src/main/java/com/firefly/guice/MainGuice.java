package com.firefly.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * 类MainGuice.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月3日 上午4:20:40
 */
public class MainGuice {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new AnimalGuiceModule());
        AnimalGuice animal = injector.getInstance(AnimalGuice.class);
        animal.run();

    }

}
