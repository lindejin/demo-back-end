package com.ldj.demo;

import com.github.pagehelper.PageHelper;
import com.ldj.demo.domain.UserInfo;
import com.ldj.demo.mail.MailSender;
import com.ldj.demo.mail.TimeUtil;
import com.ldj.demo.service.UserService;
import com.ldj.demo.util.JwtUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="/spring/spring-context.xml")
public class TestMybatis {

    @Autowired
    private UserService userService;
    @Test
    public void Testquery(){
        //System.out.println(userService.findUsers(1,3).getList());
//        正确的打印List
        //System.out.println(Arrays.toString(userService.findUsers(1,3).getList().toArray()));
        Iterator<UserInfo> iterator = userService.findUsers(1,5).getList().iterator();
        while (iterator.hasNext()) {
            UserInfo str = iterator.next();
            System.out.println(str.toString());
        }
    }
    @Test
    public void TestMapquery(){
        System.out.println(userService.queryUser(1));
    }
    @Test
    public void TestMapsQuery(){
        System.out.println(userService.getMapQueryUsers());
    }
    @Test
    public void TestInsert()
    {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("sss");
        userInfo.setUserPass("123");
//        1000L代表换算成毫秒 3600L代表一小时的秒数  24L代表一天的24小时
        String token = JwtUtils.sign(userInfo, 24L*3600L* 1000L);
        System.out.println(token);
    }
    @Test
    public void testMail(){
        String toEmail = "806962181@qq.com";
        String identifyCode = "1111"+"有效期10分钟。";

        //调用静态方法
        MailSender mSender = new MailSender();
        mSender.sendMail(toEmail, identifyCode);

    }
    @Test
    public void testTime(){
        TimeUtil timeUtil = new TimeUtil();
        String nowTime = timeUtil.getTime();
        System.out.println(nowTime);
        boolean temp = timeUtil.cmpTime("1556606283506");
        System.out.println("------------分割线------------");
        System.out.println(temp);

    }

}
