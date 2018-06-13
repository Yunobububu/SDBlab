package com.ljk.bit.web;

import com.ljk.bit.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @PostMapping(value = "/login")
    public String login(Model model){

        return "home";
    }
    @GetMapping(value="register")
    public String register(){
        return "register";
    }
    @PostMapping(value = "registerSub")
    public String loginSuccess(@RequestParam(value = "ID")String ID, @RequestParam(value = "role") int role,Student student){
        System.out.println(role);
        student.setStudentID(ID);
        System.out.println(student);
        return "success";
    }
}
