package com.firefly.esper.selecttest;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * 类SelectEsperListener.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年4月2日 下午9:27:26
 */
public class SelectEsperListener implements UpdateListener {

    @Override
    public void update(EventBean[] newBean, EventBean[] oldBean) {
        if (null != newBean) {
            // System.out.println("this is name:" + newBean[0].get("name"));
            // System.out.println("this is are:" + newBean[0].get("are"));
            // System.out.println("this is u1Name:" + newBean[0].get("u1Name"));
            System.out.println("this is length============:" + newBean.length);
            for (EventBean bean : newBean)
                System.out.println("this is price:" + bean.get("color"));
        }

        // System.out.println(newBean[0].getUnderlying());
    }

}
