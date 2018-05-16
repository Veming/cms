package com.example.cms.controller;

import com.example.cms.dao.GoodsDAO;
import com.example.cms.dao.RecordDAO;
import com.example.cms.dao.UserDAO;
import com.example.cms.domain.Goods;
import com.example.cms.domain.Record;
import com.example.cms.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
货物出售控制
 */
//声明类的注解 相当与request注解和controller注解的组合 接收与发送都是json字符串
@RestController
//request请求的映射
@RequestMapping("/goods")
public class GoodsOutController {
    //自动注入 装配jpa接口的bin
    @Autowired
    //装载jpa中的bin,继承接口
    private GoodsDAO goodsDAO;
    @Autowired
    private RecordDAO recordDAO;
    @Autowired
    private UserDAO userDAO;

    @GetMapping(value = "")
    @ResponseBody
    public List<Goods> recordList(){
        return goodsDAO.findAll();
    }



    @PostMapping(value = "/outGoods")
    public User outGoods(@RequestBody Record record) {
        User user = userDAO.findById(record.getUid()).get();
        Integer amount = Integer.valueOf(user.getMoney())-Integer.valueOf(record.getAmount());
        user.setMoney(String.valueOf(amount));
        //持久化保存到数据库
        recordDAO.save(record);
        userDAO.save(user);
        return user;
    }
}
