package com.firefly.reactivex;

import rx.Observable;
import rx.functions.Action1;

/**
 * 类RxJavaTest.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月4日 上午5:29:35
 */
public class RxJavaTest {

    public static void main(String[] args) {
        hello("test1", "test2");
    }

    public static void hello(String... name) {
        Observable.from(name).subscribe(new Action1<String>() {

            @Override
            public void call(String name) {
                System.out.println("hello:" + name);

            }
        });
    }
}
