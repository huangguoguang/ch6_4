package com.wisely.ch6_4;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Jobs {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //fixedRate就是每多次分钟一次，不论你业务执行花费了多少时间。我都是1分钟执行1次，
    //而fixedDelay是当任务执行完毕后1分钟在执行
    //0 0 3 * * ?     每天3点执行
    //0 5 3 * * ?     每天3点5分执行
    //0 5 3 ? * *     每天3点5分执行，与上面作用相同
    //0 5/10 3 * * ?  每天3点的 5分，15分，25分，35分，45分，55分这几个时间点执行
    //0 10 3 ? * 1    每周星期天，3点10分 执行，注：1表示星期天
    //0 10 3 ? * 1#3  每个月的第三个星期，星期天 执行，#号只能出现在星期的位置
    //(*)星号：可以理解为每的意思，每秒，每分，每天，每月，每年...
    //(?)问号：问号只能出现在日期和星期这两个位置，表示这个位置的值不确定，每天3点执行，所以第六位星期的位置，我们是不需要关注的，就是不确定的值。同时：日期和星期是两个相互排斥的元素，通过问号来表明不指定值。比如，1月10日，比如是星期1，如果在星期的位置是另指定星期二，就前后冲突矛盾了。
    //(-)减号：表达一个范围，如在小时字段中使用“10-12”，则表示从10到12点，即10,11,12
    //(,)逗号：表达一个列表值，如在星期字段中使用“1,2,4”，则表示星期一，星期二，星期四
    // (/)斜杠：如：x/y，x是开始值，y是步长，比如在第一位（秒） 0/15就是，从0秒开始，每15秒，最后就是0，15，30，45，60    另：*/y，等同于0/y

    @Scheduled(fixedDelay = 10000)
    public void timeDelay() {
        System.out.println(sdf.format(new Date()) + "fixedDelay执行");
    }

    @Scheduled(fixedRate = 20000)
    public void timeRate() {
        System.out.println(sdf.format(new Date()) + "fixedRate执行");
    }

    @Scheduled(cron = "0 35 22 * * ?")
    public void testCron() {
        System.out.println(sdf.format(new Date()) + "cron执行");
    }
}
