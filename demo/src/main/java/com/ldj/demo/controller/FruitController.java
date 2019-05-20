package com.ldj.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ldj.demo.domain.FruitInfo;
import com.ldj.demo.service.FruitService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * @author ldj
 * @date 2019/4/19 11:20
 */
@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    private static final Logger logger = LoggerFactory.getLogger(FruitController.class);

    private static final String UPLOAD_FOLDER = "D:\\CCleaner\\fruit\\test\\static\\style\\images\\";

    /**
     * 增加水果，用户操作成功
     * @param fruitInfo
     * @param file
     * @param request
     * @return
     */
    @PostMapping(value = "/add")
    public int addFruit(String fruitInfo,MultipartFile file, HttpServletRequest request){
        System.out.println(fruitInfo.toString());
        FruitInfo fruitInfo1 = (FruitInfo) JSONObject.parseObject(fruitInfo,FruitInfo.class);
        System.out.println(fruitInfo1.toString());
        System.out.println(file.getOriginalFilename());
        System.out.println();
        // fruitService.saveFruit(fruitInfo);
        // 存图片
        logger.debug("传入的文件参数：{}", file.toString());
        if (Objects.isNull(file) || file.isEmpty()) {
            System.out.println("文件为空");
        }
        if (file == null) {
            System.out.println("文件为空");
        }
        try {
            byte[] bytes = file.getBytes();
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            Path path = Paths.get(UPLOAD_FOLDER + uuid+file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            System.out.println("文件写入成功...");
            fruitInfo1.setFruitStatus("0");

            // String str[] = path.toString().split("D:/CCleaner/fruit/test/")
            fruitInfo1.setFruitImage("static/style/images/"+uuid+file.getOriginalFilename());
            fruitService.saveFruit(fruitInfo1);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        // return 0;
    }
    @PostMapping("/updata")
    public int updataFruit(String fruitInfo,MultipartFile file, HttpServletRequest request){
        System.out.println(fruitInfo.toString());
        FruitInfo fruitInfo1 = (FruitInfo) JSONObject.parseObject(fruitInfo,FruitInfo.class);
        System.out.println(fruitInfo1.toString());
        if(file!=null){
            System.out.println(file.getOriginalFilename());
            System.out.println();
            // fruitService.saveFruit(fruitInfo);
            // 存图片
            logger.debug("传入的文件参数：{}", file.toString());
            if (Objects.isNull(file) || file.isEmpty()) {
                System.out.println("文件为空");
            }

            try {
                byte[] bytes = file.getBytes();
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                Path path = Paths.get(UPLOAD_FOLDER + uuid+file.getOriginalFilename());
                //如果没有files文件夹，则创建
                if (!Files.isWritable(path)) {
                    Files.createDirectories(Paths.get(UPLOAD_FOLDER));
                }
                //文件写入指定路径
                Files.write(path, bytes);
                System.out.println("文件写入成功...");
                fruitInfo1.setFruitStatus("0");

                // String str[] = path.toString().split("D:/CCleaner/fruit/test/")
                fruitInfo1.setFruitImage("static/style/images/"+uuid+file.getOriginalFilename());
                fruitService.modifyFruit(fruitInfo1);
                return 1;
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
            fruitInfo1.setFruitStatus("0");
         return fruitService.modifyFruit(fruitInfo1);
    }
    @DeleteMapping("/delete")
    public int deleteFruit(String fruitInfo,MultipartFile file, HttpServletRequest request){
        System.out.println(fruitInfo.toString());
        FruitInfo fruitInfo1 = (FruitInfo) JSONObject.parseObject(fruitInfo,FruitInfo.class);
        System.out.println(fruitInfo1.toString());
        fruitInfo1.setFruitStatus("1");
        return fruitService.modifyFruit(fruitInfo1);
    }
    @PutMapping("/updataup")
    public int updataFruit01(@RequestBody FruitInfo fruitInfo)
    {
        fruitInfo.setFruitStatus("0");
        System.out.println(fruitInfo.toString());
        return fruitService.modifyFruit(fruitInfo);
    }@PutMapping("/updatadown")
    public int updataFruit02(@RequestBody FruitInfo fruitInfo)
    {
        fruitInfo.setFruitStatus("1");
        System.out.println(fruitInfo.toString());
        return fruitService.modifyFruit(fruitInfo);
    }
    @GetMapping("/select")
    public PageInfo<FruitInfo> selectFruit(@RequestParam Map<String, Object> params, int pageNumber, int pageSize){
//        for (String key : params.keySet()) {
//            System.out.println("Key = " + key);
//        }
//        for (Object value : params.values()) {
//            System.out.println("Value = " + value);
//        }
        return fruitService.findFruit01(params);
    }
    @GetMapping("/select02")
    public PageInfo<FruitInfo> selectFruit02(@RequestParam Map<String, Object> params, int pageNumber, int pageSize){
        for (String key : params.keySet()) {
            System.out.println("Key = " + key);
        }
        for (Object value : params.values()) {
            System.out.println("Value = " + value);
        }
        return fruitService.findFruit02(params);
    }
    @GetMapping("/select03")
    public FruitInfo selectFruit03(@RequestBody FruitInfo fruitInfo){

        return fruitService.findFruit(fruitInfo);
    }

}
