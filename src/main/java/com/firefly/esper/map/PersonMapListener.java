package com.firefly.esper.map;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * 类PersonMapListener.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月30日 上午1:17:50
 */
public class PersonMapListener implements UpdateListener {

    @Override
    public void update(EventBean[] newEvent, EventBean[] oldEvent) {
        if (null != newEvent) {
            System.out.println(newEvent[0].get("age"));
        }
    }

}
