package com.firefly.esper;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

/**
 * 类PersonEsperTest.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月29日 上午1:33:26
 */
public class PersonEsperTest {

    public static void main(String[] args) {
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
        EPAdministrator admin = epService.getEPAdministrator();

        String person = Person.class.getName();
        String epl = "select name,age from " + person + " where name='xxxx'";
        EPStatement state = admin.createEPL(epl);
        state.addListener(new PersonListener());

        EPRuntime runtime = epService.getEPRuntime();
        Person s1 = new Person();
        s1.setName("xxxx");
        s1.setAge(10);
        runtime.sendEvent(s1);

        Person s2 = new Person();
        s2.setName("test");
        s2.setAge(20);
        runtime.sendEvent(s2);
        Person s3 = new Person();
        s3.setName("test");
        s3.setAge(30);
        runtime.sendEvent(s3);

    }
}
