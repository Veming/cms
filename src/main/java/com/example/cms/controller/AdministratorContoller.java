package com.example.cms.controller;

import com.example.cms.dao.StuffDAO;
import com.example.cms.dao.UserDAO;
import com.example.cms.domain.Stuff;
import com.example.cms.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
管理员控制台
 */
@RequestMapping("/administrator")
@RestController
public class AdministratorContoller {
    @Autowired
    private StuffDAO stuffDAO;

    @Autowired
    private UserDAO userDAO;

//    添加新员工
    @PostMapping("/stuffAdd")
    public Stuff stuffAdd(@RequestBody Stuff stuff ){
        stuffDAO.save(stuff);
        return stuff;
    }

//    删除员工
    @DeleteMapping(value = "/deleteStuff/{sid}")
    public List<Stuff> stuffDelete(@PathVariable("sid") Integer sid){
        stuffDAO.deleteById(sid);
        return stuffDAO.findAll();
    }

//员工更新
    @PutMapping(value = "/staffUpdate")
    public void stuffUpdate(@RequestBody Stuff stuff){
        stuffDAO.save(stuff);
    }
//      查询员工
    @GetMapping(value = "/stuff")
    @ResponseBody
    public List<Stuff> stuffList (){
        return stuffDAO.findAll();
    }

    @PutMapping(value = "/user/update")
    public void userUpdate(@RequestBody User user){
        userDAO.save(user);
    }



}
