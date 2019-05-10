package com.ldj.demo.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ldj.demo.domain.UserInfo;
import com.ldj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @PostMapping("/add")
    public int addUser(@RequestParam UserInfo userInfo){
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
    public PageInfo<UserInfo> login(UserInfo userInfo){
        userService.getUsers();
        return userService.findUsers(1,3);
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
