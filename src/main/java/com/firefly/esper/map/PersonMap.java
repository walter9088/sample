package com.firefly.esper.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

/**
 * 类PersonMap.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月30日 上午1:09:58
 */
public class PersonMap {

    public static void main(String[] args) {
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
        EPAdministrator admin = epService.getEPAdministrator();

        // Address定义
        Map<String, Object> address = new HashMap<String, Object>();
        address.put("road", String.class);
        address.put("street", String.class);
        address.put("houseNo", int.class);

        Map<String, Object> person = new HashMap<String, Object>();
        person.put("name", String.class);
        person.put("age", int.class);
        person.put("children", List.class);
        person.put("phones", Map.class);
        person.put("address", "Address");

        /**
         * person引用address，所以Address必须在person之前注册
         */
        admin.getConfiguration().addEventType("Address", address);

        /**
         * 注册person到esper
         */
        admin.getConfiguration().addEventType("Person", person);

        String epl = "select age,children from  Person where name=\"Jordan\"";

        EPStatement state = admin.createEPL(epl);
        state.addListener(new PersonMapListener());

        EPRuntime runtime = epService.getEPRuntime();
        Map<String, Object> per = new HashMap<>();
        per.put("name", "Jordan");
        per.put("age", 10);
        runtime.sendEvent(per, "Person");

        String t = "select road from Address where road=\"road\"";
        admin.createEPL(t).addListener(new xxxTest());
        Map<String, Object> e = new HashMap<>();
        e.put("road", "road");
        runtime.sendEvent(e, "Address");

    }

}
