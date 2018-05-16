package com.example.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping(value = "/")
    public String index(){return "index";}

    @RequestMapping(value = "/admin-login")
    public String adminLogin(){
        return "admin-login";
    }

    @RequestMapping(value = "/staff-login")
    public String staffLogin(){return "staff-login";}

    @RequestMapping(value = "/regist")
    public String regist(){return "regist";}

    @RequestMapping(value = "/staff-home")
    public String staffHome(){return "staff-home";}

    @RequestMapping(value = "/user-home")
    public String userHome(){return "user-home";}

    @RequestMapping(value = "/admin-home")
    public String adminHome(){return "admin-home";}

}
