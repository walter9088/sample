package com.firefly.esper.selecttest;

import java.util.HashMap;
import java.util.Map;

import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.firefly.esper.BuildTestData;
import com.firefly.esper.BuildTestEpl;

/**
 * 类EsperSelectTest.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年4月2日 下午9:18:34
 */
public class EsperSelectTest {

    public static void main(String[] args0) {
        EPServiceProvider service = EPServiceProviderManager.getDefaultProvider();

        Map<String, Object> user = new HashMap<>();
        user.put("id", int.class);
        user.put("name", String.class);
        user.put("age", int.class);
        user.put("price", int.class);
        user.put("length", int.class);
        user.put("width", int.class);

        Map<String, Object> user1 = new HashMap<String, Object>();
        user1.put("id", int.class);
        user1.put("name", String.class);
        user1.put("price", int.class);
        user1.put("length", int.class);
        user1.put("width", int.class);

        Map<String, Object> apple = new HashMap<>();
        apple.put("id", int.class);
        apple.put("name", String.class);
        apple.put("color", String.class);
        apple.put("size", int.class);
        apple.put("price", int.class);

        String epl = "@Name(\"xxxxxxxx\") select name, id as i from User";

        // String epl1 = "@Name(\"bbbb\") select avg(price) from User.win:length_batch(2)";

        epl = "select name ,id as i from User(price>200).win:length(2)";

        epl = "select length*width as are,name from User";

        // 多事件流查询
        epl = "select u1.name as u1Name,u.name as uName from User1.win:time(3) as u1,User.win:time(3) as u where u1.id=u.id";

        // 事件过虑：过虑条件写在别名之后,过虑可考虑><=,in[] () not in ,between,and ,or,>=,<=,!=
        epl = "select name from User(age>10) as xx";

        // Aggregation 聚合:avn,sum
        epl = "select avg(price) as Price from User.win:time(5 sec)";

        epl = BuildTestEpl.getWhereTestEpl();

        EPAdministrator admin = service.getEPAdministrator();
        admin.getConfiguration().addEventType("User", user);
        admin.getConfiguration().addEventType("User1", user1);
        admin.getConfiguration().addEventType("Apple", apple);
        admin.createEPL(epl).addListener(new SelectEsperListener());
        EPRuntime runtime = service.getEPRuntime();

        BuildTestData.buildGroupByTestData(runtime);

        // Map<String, Object> o1 = new HashMap<String, Object>();
        // o1.put("id", 1);
        // o1.put("name", "o1");
        // o1.put("age", 11);
        // o1.put("price", 5000);
        // o1.put("length", 20);
        // o1.put("width", 30);
        // runtime.sendEvent(o1, "User");
        //
        // Map<String, Object> o2 = new HashMap<String, Object>();
        // o2.put("id", 1);
        // o2.put("name", "o2");
        // o2.put("price", 2000);
        // runtime.sendEvent(o2, "User");
        //
        // Map<String, Object> u1o2 = new HashMap<String, Object>();
        // u1o2.put("id", 1);
        // u1o2.put("name", "vvv");
        // u1o2.put("price", 2000);
        // runtime.sendEvent(u1o2, "User1");

    }
}
