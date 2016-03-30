package com.firefly.esper;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

/**
 * 类EsperTest.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月29日 上午12:32:01
 */
public class EsperTest {

    public static void main(String[] args) {
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
        EPAdministrator admin = epService.getEPAdministrator();
        String product = Apple.class.getName();
        String epl = "select avg(price),id from " + product + ".win:length_batch(4)";
        epl = "select avg(price),id from " + product;
        EPStatement state = admin.createEPL(epl);
        state.addListener(new AppleListener());

        EPRuntime runtime = epService.getEPRuntime();
        Apple apple1 = new Apple();
        apple1.setId(1);
        apple1.setPrice(5);
        runtime.sendEvent(apple1);

        Apple apple2 = new Apple();
        apple2.setId(2);
        apple2.setPrice(2);
        runtime.sendEvent(apple2);

        Apple apple3 = new Apple();
        apple3.setId(3);
        apple3.setPrice(6);
        runtime.sendEvent(apple3);

        Apple apple4 = new Apple();
        apple3.setId(4);
        apple3.setPrice(6);
        runtime.sendEvent(apple4);
    }

}
