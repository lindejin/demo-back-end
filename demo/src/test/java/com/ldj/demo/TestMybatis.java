package com.ldj.demo;

import com.github.pagehelper.PageHelper;
import com.ldj.demo.common.base.exception.BaseBusinessException;
import com.ldj.demo.domain.CartInfo;
import com.ldj.demo.domain.FruitInfo;
import com.ldj.demo.domain.UserInfo;
import com.ldj.demo.mail.MailSender;
import com.ldj.demo.mail.TimeUtil;
import com.ldj.demo.mapper.CartInfoMapper;
import com.ldj.demo.service.CartService;
import com.ldj.demo.service.FruitService;
import com.ldj.demo.service.UserService;
import com.ldj.demo.util.JwtUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="/spring/spring-context.xml")
public class TestMybatis {

    @Autowired
    private UserService userService;
    @Autowired
    private FruitService fruitService;
    @Autowired(required=false)
    private CartService cartService;
    @Autowired(required=false)
    private CartInfoMapper cartInfoMapper;
    @Autowired(required=false)
    @Test
    public void Testquery(){
        //System.out.println(userService.findUsers(1,3).getList());
//        正确的打印List
        //System.out.println(Arrays.toString(userService.findUsers(1,3).getList().toArray()));
//        Iterator<UserInfo> iterator = userService.findUsers(1,5).getList().iterator();
        Iterator<UserInfo> iterator = userService.getUsers().iterator();
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
        boolean temp = timeUtil.cmpTime("1556775726369");
        System.out.println("------------分割线------------");
        System.out.println(temp);
        System.out.println("哈哈哈哈123");

    }
    @Test
    public void TestInsertUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("eee");
        userInfo.setUserPass("eee");
        Short s = 0;
        userInfo.setUserRole(s);
        userService.saveUser(userInfo);
        System.out.println(userInfo.getUserId());
        // 测试结果，可以直接获得主键
    }
    @Test
    public void TestInsertUserList(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","z");
        map.put("pageNumber",1);
        map.put("pageSize",5);

        Iterator<UserInfo> iterator = userService.findUserList1(map).getList().iterator();
        while (iterator.hasNext()) {
            UserInfo str = iterator.next();
            System.out.println(str.toString());
        }
    }
    @Test
    public void TestInsertUser01(){
        System.out.println(userService.findUser01("lindj"));
    }
    @Test
    public  void TsetStringImgUrl(){
        String url = "D:/CCleaner/fruit/test/static/style/images/et4.png";
        String str[] = url.split("D:/CCleaner/fruit/test/");
        System.out.println(str[1].toString());
    }
    @Test
    public void TestFruitList02(){
        Map<String, Object> map = new HashMap<>();
        // map.put("name","");
        map.put("pageNumber",1);
        map.put("pageSize",5);

        Iterator<FruitInfo> iterator = fruitService.findFruit02(map).getList().iterator();
        while (iterator.hasNext()) {
            FruitInfo str = iterator.next();
            System.out.println(str.toString());
        }
    }
    @Test
    public void TestCart(){
        CartInfo cartInfo = new CartInfo();
        cartInfo.setUserId(new Long(1));
        cartInfo.setOrderId(new Long(1));
        cartInfo.setCartStatus("0");
        cartInfo.setIsChecked(new Short("1"));
        if((cartInfoMapper.insertSelective(cartInfo)) == 0){
            throw new BaseBusinessException("抛出业务异常");
        }
        System.out.println(cartInfo);
    }
    @Test
    public void TestCartListMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("pageNumber",1);
        map.put("pageSize",2);

        Iterator<Map<String, Object>> iterator = cartInfoMapper.findCartFruitMap(map).iterator();
        while (iterator.hasNext()) {
            Map<String, Object> str = iterator.next();
            for (String key : str.keySet()) {
                System.out.println("Key = " + key);
            }
            for (Object value : str.values()) {
                System.out.println("Value = " + value);
            }
        }
    }
    @Test
    public void TestCartupdata(){
        List<Long> longs = new ArrayList<>();
        longs.add(new Long(6));
        System.out.println(cartService.modifyCartInfo(longs));
    }
    @Test
    public void Testlogin(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserPass("123");
        userInfo.setUserName("lindj");
        userInfo.setUserRole(new Short("0"));
        UserInfo userInfo02=userService.getUser(userInfo);
        System.out.println(userInfo02.toString());
    }


}
