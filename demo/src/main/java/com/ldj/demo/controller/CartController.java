package com.ldj.demo.controller;

import com.github.pagehelper.PageInfo;
import com.ldj.demo.domain.CartInfo;
import com.ldj.demo.domain.OrderDetailInfo;
import com.ldj.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author ldj
 * @date 2019/4/19 11:20
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public int addCart(@RequestBody OrderDetailInfo orderDetailInfo){
        orderDetailInfo.setDetailStatus("0");
        System.out.println(orderDetailInfo.toString());
//        设置状态
        return cartService.saveCartInfo(orderDetailInfo);
    }
    @PutMapping("/updata")
    public int updataCartInfo(@RequestBody List<Long> cart_id){
        System.out.println(Arrays.toString(cart_id.toArray()));
        return cartService.modifyCartInfo(cart_id);
        // return cartService.modifyCartInfo(cartInfo);
    }
    @DeleteMapping("/delete")
    public int deleteCartInfo(@RequestBody CartInfo cartInfo){
        return cartService.removeCartInfo(cartInfo);
    }
    @GetMapping("/select")
    public PageInfo<Map<String, Object>> selectCartInfo(@RequestParam Map<String, Object> params, int pageNumber, int pageSize){
        return cartService.findCartFruitMap(params);
    }
    @GetMapping("/select02")
    public PageInfo<Map<String, Object>> selectCartInfo02(@RequestParam Map<String, Object> params, int pageNumber, int pageSize){
        return cartService.findCartFruitMap02(params);
    }
    @GetMapping("/select03")
    public PageInfo<Map<String, Object>> selectCartInfo03(@RequestParam Map<String, Object> params, int pageNumber, int pageSize){
        return cartService.findCartFruitMap03(params);
    }
}
