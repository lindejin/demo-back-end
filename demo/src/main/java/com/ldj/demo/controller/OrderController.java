package com.ldj.demo.controller;

import com.ldj.demo.domain.OrderInfo;
import com.ldj.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author ldj
 * @date 2019/4/19 11:20
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public int addOrder(@RequestParam OrderInfo orderInfo){
        return orderService.saveOrder(orderInfo);
    }
    @PutMapping("/updata")
    public int updataOrder(@RequestBody OrderInfo orderInfo){
        orderInfo.setSendTime(new Date());
        // System.out.println(orderInfo);
//        return 1;
        return orderService.removeOrder(orderInfo);
    }

    @DeleteMapping("/delete")
    public int deleteOrder(@RequestParam OrderInfo orderInfo){
        return orderService.removeOrder(orderInfo);
    }
    @GetMapping("/select")
    public int selectOrder(){
        return 0;
    }
}
