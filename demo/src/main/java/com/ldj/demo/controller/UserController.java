package com.ldj.demo.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ldj.demo.domain.UserInfo;
import com.ldj.demo.mail.MailSender;
import com.ldj.demo.service.UserService;
import com.ldj.demo.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author ldj
 * @date 2019/4/19 11:20
 */
// @CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/select01")
    public int selectUser01(String name){
        System.out.println(name);
        return userService.findUser01(name);
    }
    @GetMapping("/mail")
    public int Mail(String userEmail,HttpServletRequest request){
        System.out.println(userEmail);
        String toEmail = userEmail;
        String identifyCode = "1111"+"有效期10分钟。";
        //调用静态方法
        if(MailSender.sendMail(toEmail, identifyCode)){
            HttpSession session = request.getSession();
            String code = "1111";
            session.setAttribute("email",code);
            return 0;
        } else {
            return 1;
        }
    }
    @GetMapping("/getCode")
    public String GetEmail(HttpServletRequest request){
        HttpSession session = request.getSession();
        String code = session.getAttribute("email").toString();
        System.out.println(code);
        /*注销session*/
//        request.getSession().removeAttribute("email");
        return  code;
    }
    @PostMapping("/add")
    public int addUser(@RequestBody UserInfo userInfo){
        userInfo.setUserState("0");
        userInfo.setUserRole(Short.valueOf("0"));
        System.out.println(userInfo.toString());
        return userService.saveUser(userInfo);
    }
    @PutMapping("/updata")
    public int updataUser(@RequestParam UserInfo userInfo){
        return userService.modifyUser(userInfo);
    }
    @DeleteMapping("/delete")
    public int deleteUser(@RequestParam UserInfo userInfo){
        return userService.removeUser(userInfo);
    }
    @GetMapping("/select")
    public PageInfo<UserInfo> selectUser(@RequestParam Map<String, Object> params,int pageNumber,int pageSize){
//        for (String key : params.keySet()) {
//            System.out.println("Key = " + key);
//        }
//        for (Object value : params.values()) {
//            System.out.println("Value = " + value);
//        }
        return userService.findUserList1(params);
    }

    @GetMapping("/login")
    public Map<String,Object> login(String userName,String userPass){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserPass(userPass);
        userInfo.setUserName(userName);
        userInfo.setUserRole(new Short("0"));
        UserInfo userInfo02=userService.getUser(userInfo);
        System.out.println(userInfo02.toString());
        String token = JwtUtils.sign(userInfo02, 24L*3600L* 1000L);
        Map<String,Object> model = new HashMap<>();
        model.put("token", token);
        model.put("userid", userInfo02.getUserId().toString());
        return model;
    }
    @GetMapping("/login02")
    public Map<String,Object> login02(String userName,String userPass){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserPass(userPass);
        userInfo.setUserName(userName);
        userInfo.setUserRole(new Short("1"));
        System.out.println(userInfo);
        UserInfo userInfo02 = userService.getUser(userInfo);
        String token = JwtUtils.sign(userInfo02, 24L*3600L* 1000L);
        Map<String,Object> model = new HashMap<>();
        model.put("token", token);
        model.put("userid", userInfo02.getUserId());
        return model;
    }
    @GetMapping("/user")
    public List<UserInfo> users(UserInfo userInfo){
        return userService.getUsers();
    }
    @GetMapping("/users")
    public PageInfo<UserInfo> login( int pageNumber,int pageSize){
        //userService.getUsers();
        //System.out.println(pageSize);
        return userService.findUsers(pageSize,pageNumber);
    }
    @GetMapping("/test")
    public PageInfo<UserInfo> test(){
        //userService.getUsers();
        //System.out.println(pageSize);
        return userService.findUsers(1,5);
    }
    @GetMapping("/test1")
    public PageInfo<UserInfo> test1(){
        //userService.getUsers();
        //System.out.println(pageSize);
        return userService.findUsers(1,5);
    }
    @GetMapping("/saveSESSION")
    public void savesession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String code = "1111";
        session.setAttribute("session",code);
    }
    @GetMapping("/getSESSION")
    public void getsession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("session"));
        /*注销session*/
        request.getSession().removeAttribute("session");
    }

}
