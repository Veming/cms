package com.example.cms.controller;

/*
员工控制台
 */
import com.example.cms.dao.UserDAO;
import com.example.cms.domain.Stuff;
import com.example.cms.dao.StuffDAO;
import com.example.cms.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stuff")
public class StuffController {

    @Autowired
    private StuffDAO stuffDAO;

    @Autowired
    private UserDAO userDAO;

    @GetMapping(value = "/tostuff")
    public String user_login(){
        return "index";
    }
    @GetMapping(value = "/{sid}")
    @ResponseBody
    public Stuff getStuff(@PathVariable("sid") Integer sid){
        return stuffDAO.findById(sid).get();
    }


    @PutMapping(value = "/update")
    public void stuffUpdate(@RequestBody Stuff stuff){
        stuffDAO.save(stuff);
    }

    @GetMapping(value = "/userList")
    @ResponseBody
    public List<User> userList(){
        return userDAO.findAll();
    }

    @GetMapping(value = "/getUser/{uid}")
    @ResponseBody
    public User getUser(@PathVariable("uid") Integer uid){
        return userDAO.findById(uid).get();
    }

    @PostMapping("/userAdd")
    public User userAdd(@RequestBody User user ){
        userDAO.save(user);
        return user;
    }

    @DeleteMapping(value = "/deleteUser/{uid}")
    public List<User> userDelete(@PathVariable("uid") Integer uid){

        userDAO.deleteById(uid);
        return userDAO.findAll();
    }

}
