package com.firefly.esper;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * 类PersonListener.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月29日 上午1:24:59
 */
public class PersonListener implements UpdateListener {

    @Override
    public void update(EventBean[] newEvent, EventBean[] oldEvent) {

        if (null != newEvent) {
            System.out.println("event length:" + newEvent.length);
            for (EventBean bean : newEvent) {
                System.out.println("this is person:" + bean.get("age"));
            }
        }
    }

}
