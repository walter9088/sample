package com.firefly.tes;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类TestAtomicInteger.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年4月8日 下午4:12:19
 */
public class TestAtomicInteger {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        for (int t = 0; t < 10; t++) {
            System.out.println(i.getAndIncrement());
        }
    }
}
