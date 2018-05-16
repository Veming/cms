package com.example.cms.controller;

import com.example.cms.dao.AdministratorDAO;
import com.example.cms.dao.RecordDAO;
import com.example.cms.dao.StuffDAO;
import com.example.cms.dao.UserDAO;
import com.example.cms.domain.Administrator;
import com.example.cms.domain.Record;
import com.example.cms.domain.Stuff;
import com.example.cms.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
登陆控制
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private StuffDAO stuffDAO;
    @Autowired
    private AdministratorDAO administratorDAO;
    @Autowired
    private RecordDAO recordDAO;

//    公司员工登陆
    @PostMapping(value = "/staff")
    @ResponseBody
    public Stuff stuffLogin(@RequestBody Stuff stuff){
        System.out.println(stuff.getUsername());
        System.out.println(stuff.getPassword());
        return stuffDAO.stuffLogin(stuff.getUsername(), stuff.getPassword());
    }

//    管理员登陆
    @PostMapping(value = "/admin")
    @ResponseBody
    public Administrator getAdministrator(@RequestBody Administrator administrator){
        return administratorDAO.administrator(administrator.getaUsername(),administrator.getaPassword());
    }

//    用户签到打卡
    @PostMapping(value = "/sign")
    public User sign(@RequestBody Record record) {
        System.out.println(1);

        User user = userDAO.findById(record.getUid()).get();
        System.out.println(user);
        Integer amount = Integer.valueOf(user.getMoney())-Integer.valueOf(record.getAmount());
        System.out.println(amount);
        user.setMoney(String.valueOf(amount));
        recordDAO.save(record);
        userDAO.save(user);
        System.out.println(user);

        return user;
    }

}
