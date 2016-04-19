package com.firefly.esper.aggregation;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * 类AggregationListener.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月30日 下午8:20:48
 */
public class AggregationListener implements UpdateListener {

    @Override
    public void update(EventBean[] newEventBean, EventBean[] oldEventBean) {
        if (null != newEventBean) {
            System.out.println("this length:" + newEventBean.length);
            System.out.println("this is sum:" + newEventBean[0].get("sum(amount)"));
        }
    }

}
