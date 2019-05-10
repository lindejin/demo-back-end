package com.ldj.demo.controller;

import com.ldj.demo.domain.UserInfo;
import com.ldj.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ldj
 * @date 2019/4/19 11:20
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public int addAdmin(@RequestParam UserInfo userInfo){
        return adminService.saveAdmin(userInfo);
    }
    @PutMapping("/updata")
    public int updataAdmin(@RequestParam UserInfo userInfo){
        return adminService.modifyAdmin(userInfo);
    }
    @DeleteMapping("/delete")
    public int deleteAdmin(@RequestParam UserInfo userInfo){
        return adminService.removeAdmin(userInfo);
    }
    @GetMapping("/select")
    public int selectAdmin(){
        return 0;
    }
}
