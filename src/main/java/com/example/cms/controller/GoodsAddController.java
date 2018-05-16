package com.example.cms.controller;

import com.example.cms.dao.GoodsDAO;
import com.example.cms.domain.Goods;
import com.example.cms.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
货物添加控制
 */
@RestController
@RequestMapping(value = "/goods")
public class GoodsAddController {
    @Autowired
    private GoodsDAO goodsDAO;

    @PostMapping("/goodsAdd")
    @ResponseBody
    public Goods goodsAdd(@RequestBody Goods goods ){
        goodsDAO.save(goods);
        return goods;
    }

    @DeleteMapping(value = "/deleteGoods/{gid}")
    public List<Goods> goodsDelete(@PathVariable("gid") Integer gid){

        goodsDAO.deleteById(gid);
        return goodsDAO.findAll();
    }

    @GetMapping(value = "/goodsList")
    @ResponseBody
    public List<Goods> goodsList(){
        return goodsDAO.findAll();
    }
}
