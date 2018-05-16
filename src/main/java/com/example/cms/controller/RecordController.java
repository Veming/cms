package com.example.cms.controller;

/*
交易记录
 */
import com.example.cms.dao.UserDAO;
import com.example.cms.domain.Record;
import com.example.cms.dao.RecordDAO;
import com.example.cms.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/record")
public class RecordController {

    @Autowired
    private RecordDAO recordDAO;

    @Autowired
    private UserDAO userDao;

    @GetMapping(value = "")
    @ResponseBody
    public List<Record> recordList(){
        return recordDAO.findAll();
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public User recordAdd(@RequestBody Record record ){
//      保存记录
        recordDAO.save(record);
//        更改用户金额信息
        Integer uid = record.getUid();
        User user = userDao.getOne(uid);
        Integer amount = Integer.valueOf(record.getAmount())+Integer.valueOf(user.getMoney());
        user.setMoney(String.valueOf(amount));

        userDao.save(user);
//      返回校验信息

        return userDao.findById(uid).get();

    }

    @PostMapping(value = "/adduse")
    @ResponseBody
    public User recordAdd2(@RequestBody Record record ){
//      保存记录
        recordDAO.save(record);
//        更改用户金额信息
        Integer uid = record.getUid();
        User user = userDao.getOne(uid);
        Integer amount = Integer.valueOf(record.getAmount())-Integer.valueOf(user.getMoney());
        user.setMoney(String.valueOf(amount));

        userDao.save(user);
//      返回校验信息

        return userDao.findById(uid).get();

    }

}
