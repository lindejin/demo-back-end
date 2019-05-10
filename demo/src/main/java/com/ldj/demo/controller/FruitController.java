package com.ldj.demo.controller;

import com.ldj.demo.domain.FruitInfo;
import com.ldj.demo.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ldj
 * @date 2019/4/19 11:20
 */
@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @PostMapping("/add")
    public int addFruit(@RequestParam FruitInfo fruitInfo){
        return fruitService.saveFruit(fruitInfo);
    }
    @PutMapping("/updata")
    public int updataFruit(@RequestParam FruitInfo fruitInfo){
        return fruitService.modifyFruit(fruitInfo);
    }
    @DeleteMapping("/delete")
    public int deleteFruit(@RequestParam FruitInfo fruitInfo){
        return fruitService.removeFruit(fruitInfo);
    }
    @GetMapping("/select")
    public int selectFruit(){
        return 0;
    }
}
