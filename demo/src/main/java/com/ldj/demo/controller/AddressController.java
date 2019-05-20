package com.ldj.demo.controller;

import com.github.pagehelper.PageInfo;
import com.ldj.demo.domain.AddressInfo;
import com.ldj.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ldj
 * @date 2019/4/19 11:20
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public int addAddress(@RequestBody AddressInfo addressInfo){
        System.out.println(addressInfo.toString());
//        设置状态
        addressInfo.setAddressState("0");
//        addressInfo.setUserId(new Long(1));
        return addressService.saveAddress(addressInfo);
    }
    @PutMapping("/updata")
    public int updataAddress(@RequestBody AddressInfo addressInfo){
        System.out.println(addressInfo.toString());
        return addressService.modifyAddress(addressInfo);
    }
    @PutMapping("/delete")
    public int deleteAddress(@RequestBody AddressInfo addressInfo){
        addressInfo.setAddressState("2");
        System.out.println(addressInfo);
        return addressService.removeAddress(addressInfo);
    }
    @GetMapping("/select")
    public PageInfo<AddressInfo> selectAddress(@RequestParam Map<String, Object> params, int pageNumber, int pageSize){
        return addressService.findAddressList01(params);
    }
}
