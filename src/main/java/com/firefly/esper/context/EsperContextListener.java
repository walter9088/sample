package com.firefly.esper.context;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * 类EsperContextListener.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月30日 下午9:20:16
 */
public class EsperContextListener implements UpdateListener {

    @Override
    public void update(EventBean[] newEventBean, EventBean[] oldEventBean) {
        if (null != newEventBean) {
            System.out.println("this is context.name:" + newEventBean[0].get("name") + " this is context.key1:"
                               + newEventBean[0].get("key2"));
        }
    }

}
