package com.firefly.esper;

import java.util.HashMap;
import java.util.Map;

import com.espertech.esper.client.EPRuntime;

/**
 * 类BuildTestData.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年4月3日 下午1:58:15
 */
public class BuildTestData {

    public static void buildGroupByTestData(EPRuntime runtime) {
        Map<String, Object> a1 = new HashMap<String, Object>();
        a1.put("id", 1);
        a1.put("name", String.class);
        a1.put("color", "red");
        a1.put("size", 10);
        a1.put("price", 7);
        runtime.sendEvent(a1, "Apple");

        Map<String, Object> a2 = new HashMap<String, Object>();
        a2.put("id", 1);
        a2.put("name", String.class);
        a2.put("color", "red");
        a2.put("size", 10);
        a2.put("price", 6);
        runtime.sendEvent(a2, "Apple");

        Map<String, Object> a3 = new HashMap<String, Object>();
        a3.put("id", 1);
        a3.put("name", String.class);
        a3.put("color", "red");
        a3.put("size", 10);
        a3.put("price", 10);
        runtime.sendEvent(a3, "Apple");

        Map<String, Object> a4 = new HashMap<String, Object>();
        a4.put("id", 1);
        a4.put("name", String.class);
        a4.put("color", "yello");
        a4.put("size", 10);
        a4.put("price", 9);
        runtime.sendEvent(a4, "Apple");
    }
}
