package com.firefly.esper;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * 类AppleListener.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月29日 上午12:57:37
 */
public class AppleListener implements UpdateListener {

    @Override
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        if (newEvents != null) {
            Double avg = (Double) newEvents[0].get("avg(price)");
            System.out.println("this is avg=====>" + avg);
        }
    }

}
