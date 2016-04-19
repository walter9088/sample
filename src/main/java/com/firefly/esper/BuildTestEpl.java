package com.firefly.esper;

/**
 * 类BuildTestEpl.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年4月3日 下午1:59:37
 */
public class BuildTestEpl {

    /**
     * group by test
     * 
     * @return
     */
    public static String getGroupByTestEpl() {
        // 跟据color,size来对3个apple事件进行分组计算平均价格
        // length(2),每次事件触发updatelistene,每个事件间隔联合计算
        return "select avg(price) as aPrice,color,size from Apple.win:length(2) group by color,size";
    }

    /**
     * @return
     */
    public static String getGroupByTimeTestEpl() {
        // @Hint('reclaim_group_aged=8，reclaim_group_freq=2')时间事件窗，指定分组事件，在8Ｓ内无更新，则回收，回收频率2S每一次
        // @Unfinished(Description = "ERROR-> Caused by: com.espertech.esper.view.ViewParameterException: Invalid
        // parameter expression 0: Property named 'timestamp' is not valid in any stream");
        return "select avg(price) as aPrice,color,size from Apple.win:ext_timed(current_timestamp(),2 sec) group by color,size";
    }

    /**
     * @return
     */
    public static String getOutputTestEpl() {
        // output after 1 events every 5 sec决定调用updatelisten时间
        /**
         * output：at,when输出 output at output [after suppression_def] [[all | first | last | snapshot] when
         * trigger_expression [then set variable_name = assign_expression [, variable_name = assign_expression [,...]]]
         */
        return "select avg(price) as aPrice from Apple.win:time_batch(2 sec) group by color,size having avg(price)>5  ";
    }

    /**
     * insert
     * 
     * @return
     */
    public static String getInsertTestEpl() {
        return "insert into xxx select id,price from Apple";
    }

    /**
     * @return
     */
    public static String getWhereTestEpl() {
        return "select id,color from Apple where color='red'";
    }

}
