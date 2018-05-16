package com.example.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class CmsApplication {

    public static void main(String[] args) {

        SpringApplication.run(CmsApplication.class, args);
    }
//    @GetMapping(value = {"/"+"user-login"})
//    public String user_login(){
//        return "staff-login";
//    }



}
