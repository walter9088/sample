package com.firefly.esper.context;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.firefly.esper.ESB;

/**
 * 类EsperContextTest.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月30日 下午9:19:47
 */
public class EsperContextTest {

    public static void main(String[] args) {
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
        String epl1 = "create context esbtest partition by id and price from " + ESB.class.getName();

        String epl2 = "context esbtest select context.id,context.name,context.key1,context.key2  from "
                      + ESB.class.getName();
        EPAdministrator admin = epService.getEPAdministrator();
        admin.createEPL(epl1);
        EPStatement state = admin.createEPL(epl2);
        state.addListener(new EsperContextListener());

        EPRuntime runtime = epService.getEPRuntime();
        ESB e1 = new ESB();
        e1.setId(1);
        e1.setPrice(20);
        System.out.println("sendEvent: id=1, price=20");
        runtime.sendEvent(e1);

        ESB e2 = new ESB();
        e2.setId(2);
        e2.setPrice(30);
        System.out.println("sendEvent: id=2, price=30");
        runtime.sendEvent(e2);

        ESB e3 = new ESB();
        e3.setId(1);
        e3.setPrice(20);
        System.out.println("sendEvent: id=1, price=20");
        runtime.sendEvent(e3);

        ESB e4 = new ESB();
        e4.setId(4);
        e4.setPrice(20);
        System.out.println("sendEvent: id=4, price=20");
        runtime.sendEvent(e4);
    }
}
