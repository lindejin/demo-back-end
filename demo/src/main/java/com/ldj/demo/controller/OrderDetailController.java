package com.ldj.demo.controller;

import com.ldj.demo.domain.OrderDetailInfo;
import com.ldj.demo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ldj
 * @date 2019/4/19 11:22
 */
@RestController
@RequestMapping("/order_detail")
public class OrderDetailController {
    @Autowired
    private  OrderDetailService orderDetailService;
    /**
     *
     * 功能描述: 新增详情
     * @RequestParam支持类型转换，还有必需和可选参数。
     * @param: []
     * @return: int
     * @auther: ldj
     * @date: 2019/5/10 11:20
     */
    @PostMapping("/add")
    public int addOrderDetail(@RequestParam OrderDetailInfo orderDetailInfo){
        return orderDetailService.saveOrderDetail(orderDetailInfo);
    }
    @PutMapping("/updata")
    public  int updataOrderDetail(@RequestParam OrderDetailInfo orderDetailInfo){
        return orderDetailService.modifyOrderDetail(orderDetailInfo);
    }
    @DeleteMapping("/delete")
    public  int deleteOrderDetail(@RequestParam OrderDetailInfo orderDetailInfo){
        return orderDetailService.removeOrderDetail(orderDetailInfo);
    }
    @GetMapping("/select")
    public int selectOrderDetail(){
        return 0;
    }
}
