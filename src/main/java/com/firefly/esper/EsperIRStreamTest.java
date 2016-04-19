package com.firefly.esper;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

/**
 * 类EsperIRStreamTest.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年4月1日 上午2:18:26
 */
public class EsperIRStreamTest {

    public static void main(String[] args) {
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
        EPAdministrator admin = epService.getEPAdministrator();

        String person = Person.class.getName();
        String epl = "select irstream name,age from " + person + ".win:length_batch(1)";
        EPStatement state = admin.createEPL(epl);
        state.addListener(new IRStreamListener());

        EPRuntime runtime = epService.getEPRuntime();
        Person s1 = new Person();
        s1.setName("xxxx");
        s1.setAge(10);
        runtime.sendEvent(s1);

        Person s2 = new Person();
        s2.setName("test1");
        s2.setAge(20);
        runtime.sendEvent(s2);
        Person s3 = new Person();
        s3.setName("test2");
        s3.setAge(30);
        runtime.sendEvent(s3);
    }
}
