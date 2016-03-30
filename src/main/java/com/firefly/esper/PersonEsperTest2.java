package com.firefly.esper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

/**
 * 类PersonEsperTest2.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月29日 上午1:54:56
 */
public class PersonEsperTest2 {

    public static void main(String[] args) {
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
        EPAdministrator admin = epService.getEPAdministrator();
        String person = Person.class.getName();
        String epl = "select children[0], phones('home'), address.road from " + person + " where name=\"Jordan\"";

        // AUTO待验证
        // epl = "update " + person + " set phones('home')=12345678 where name=\"Jordan\"";
        EPStatement state = admin.createEPL(epl);
        state.addListener(new PersonListener2());
        EPRuntime runtime = epService.getEPRuntime();
        Person pe = new Person();
        pe.setName("Jordan");

        List<Child> cl = new ArrayList<>();
        Child ch = new Child();
        ch.setName("test1");
        cl.add(ch);
        Child ch1 = new Child();
        ch1.setName("test2");
        cl.add(ch1);
        Map<String, Integer> phones = new HashMap<String, Integer>();
        phones.put("home", 2132112);

        pe.setChildren(cl);
        pe.setPhones(phones);
        runtime.sendEvent(pe);

    }
}
