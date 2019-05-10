package com.ldj.demo.controller;

import com.ldj.demo.domain.AddressInfo;
import com.ldj.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public int addAddress(@RequestParam AddressInfo addressInfo){
        return addressService.saveAddress(addressInfo);
    }
    @PutMapping("/updata")
    public int updataAddress(@RequestParam AddressInfo addressInfo){
        return addressService.modifyAddress(addressInfo);
    }
    @DeleteMapping("/delete")
    public int deleteAddress(@RequestParam AddressInfo addressInfo){
        return addressService.removeAddress(addressInfo);
    }
    @GetMapping("/select")
    public int selectAddress(){
        return 0;
    }
}
