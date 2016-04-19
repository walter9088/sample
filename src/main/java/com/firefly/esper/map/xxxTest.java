package com.firefly.esper.map;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * 类xxxTest.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年4月8日 上午12:37:08
 */
public class xxxTest implements UpdateListener {

    @Override
    public void update(EventBean[] newBean, EventBean[] oldBean) {
        if (null != newBean) {
            System.out.println(newBean[0].get("road"));
        }
    }

}
