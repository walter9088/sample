package com.firefly.esper;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * 类IRStreamListener.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年4月1日 上午2:19:39
 */
public class IRStreamListener implements UpdateListener {

    @Override
    public void update(EventBean[] newBean, EventBean[] oldBean) {
        if (null != newBean && null != oldBean) {
            System.out.println("new Bean:" + newBean[0].get("name") + "====>old Bean:" + oldBean[0].get("name"));
        }
    }

}
