package com.ldj.demo.mail;

import java.util.Calendar;
/**
 * @author ldj
 * @date 2019/4/30 10:44
 */
public class TimeUtil {

    //获取时间  返回毫秒级时间
    public String getTime() {
        // System.out.println("getTime...util...");

        Calendar calendar = Calendar.getInstance();
        Long date = calendar.getTime().getTime();            //获取毫秒时间
        return date.toString();
    }
    //过期验证
    public boolean cmpTime(String time) {
        // System.out.println("cmpTime...util...");
        long tempTime = Long.parseLong(time);
        System.out.println("要验证的时间："+tempTime);

        //在获取现在的时间
        Calendar calendar = Calendar.getInstance();
        Long date = calendar.getTime().getTime();            //获取毫秒时间
        System.out.println("现在的时间:"+date);

        if(date - tempTime > 600000 ) {   //10分钟
            return false;
        } else {
            return true;
        }

    }
}
