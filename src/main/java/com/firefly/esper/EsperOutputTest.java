package com.firefly.esper;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class EsperOutputTest {

    public static void main(String[] args) {
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();

        EPAdministrator admin = epService.getEPAdministrator();

        String banana = Banana.class.getName();
        // 统计最新3个Banana事件的sum price，并且从EPL可用起，等待第一个事件进入后，以每两个事件进入的频率输出统计结果
        String epl = "select sum(price) as sPrice from " + banana
                     + ".win:length(3) output after 0 events snapshot every 1 events";

        EPStatement state = admin.createEPL(epl);
        state.addListener(new OutputAfterListener());

        EPRuntime runtime = epService.getEPRuntime();

        Banana b1 = new Banana();
        b1.setId(1);
        b1.setPrice(6);
        System.out.println("Send Banana Event: " + b1);
        runtime.sendEvent(b1);

        Banana b2 = new Banana();
        b2.setId(2);
        b2.setPrice(3);
        System.out.println("Send Banana Event: " + b2);
        runtime.sendEvent(b2);

        Banana b3 = new Banana();
        b3.setId(3);
        b3.setPrice(1);
        System.out.println("Send Banana Event: " + b3);
        runtime.sendEvent(b3);

        Banana b4 = new Banana();
        b4.setId(4);
        b4.setPrice(2);
        System.out.println("Send Banana Event: " + b4);
        runtime.sendEvent(b4);

        Banana b5 = new Banana();
        b5.setId(5);
        b5.setPrice(4);
        System.out.println("Send Banana Event: " + b5);
        runtime.sendEvent(b5);

    }

}

class Banana {

    private int id;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "id: " + id + ", price: " + price;
    }
}

class OutputAfterListener implements UpdateListener {

    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        if (newEvents != null) {
            int price = (Integer) newEvents[0].get("sPrice");
            System.out.println("Banana's sum price is " + price);
        }
    }
}
