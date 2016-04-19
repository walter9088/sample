package com.firefly.esper.context;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * 类EsperContextListener2.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年4月1日 上午1:06:24
 */
public class EsperContextListener2 implements UpdateListener {

    @Override
    public void update(EventBean[] newBean, EventBean[] oldBean) {
        if (null != newBean) {
            System.out.println("this is price:" + newBean[0].get("avg(price)"));
        }
    }

}
