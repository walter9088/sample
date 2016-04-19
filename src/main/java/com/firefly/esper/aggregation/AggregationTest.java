package com.firefly.esper.aggregation;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.firefly.esper.Apple;

/**
 * 类AggregationTest.java的实现描述：简单聚合测试
 * 
 * @author walter 2016年3月30日 下午8:21:32
 */
public class AggregationTest {

    public static void main(String[] args) {

        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
        EPAdministrator admin = epService.getEPAdministrator();
        String apple = Apple.class.getName();
        /*
         * 加加
         */
        String epl = "select sum(amount) from " + apple + ".win:length_batch(2)";

        /*
         * 分组
         */
        epl = "select price ,sum(amount) from " + apple + ".win:length_batch(2) group by price";

        EPStatement state = admin.createEPL(epl);
        state.addListener(new AggregationListener());
        EPRuntime runtime = epService.getEPRuntime();
        Apple a1 = new Apple();
        a1.setAmount(1000);
        runtime.sendEvent(a1);

        Apple a2 = new Apple();
        a2.setAmount(1000);
        runtime.sendEvent(a2);

        Apple a3 = new Apple();
        a3.setAmount(1000);
        runtime.sendEvent(a3);
    }
}
