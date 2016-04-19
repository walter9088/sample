package com.firefly.esper.context;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.firefly.esper.ESB;

/**
 * 类EsperContextTest2.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年4月1日 上午12:55:54
 */
public class EsperContextTest2 {

    public static void main(String[] args) {
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
        EPAdministrator admin = epService.getEPAdministrator();
        String eplContext = "create context esbtest partition by id from " + ESB.class.getName();
        admin.createEPL(eplContext);
        // 每当2个相同id进入事件时，统计总和
        String epl = "context esbtest select sum(price) from " + ESB.class.getName() + ".win:length_batch(2)";
        // 当2个相同id进入事时，统计总和,且price值》10时，进入计算窗口
        epl = "context esbtest select avg(price) from " + ESB.class.getName() + "(price>10).win:length_batch(2)";
        EPStatement state = admin.createEPL(epl);
        state.addListener(new EsperContextListener2());
        EPRuntime runtime = epService.getEPRuntime();

        ESB e1 = new ESB();
        e1.setId(1);
        e1.setPrice(50);

        runtime.sendEvent(e1);

        ESB e2 = new ESB();
        e2.setId(2);
        e2.setPrice(30);

        runtime.sendEvent(e2);

        ESB e3 = new ESB();
        e3.setId(1);
        e3.setPrice(11);

        runtime.sendEvent(e3);

        ESB e4 = new ESB();
        e4.setId(4);
        e4.setPrice(20);

        runtime.sendEvent(e4);

    }
}
