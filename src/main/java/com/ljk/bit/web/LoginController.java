package com.ljk.bit.web;

import com.ljk.bit.entity.Student;
import com.ljk.bit.service.StudentService;
import com.ljk.bit.service.serviceImpl.StudentServiceImpl;
import com.ljk.bit.util.Md5Utils;
import com.ljk.bit.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.rsa.RSASignature;

import java.io.InputStream;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping(value = "/login")
    public @ResponseBody String login(@RequestParam("ID") String ID,
                        @RequestParam("password") String password){
            String md5Psd = Md5Utils.getMD5_32bits(password);
            String psd = studentService.queryPasswordByID(ID);
            System.out.println(md5Psd);
            System.out.println(psd);
            if(md5Psd.equals(psd)){
                return "home";
            }
        return "error";
    }
    @GetMapping(value="register")
    public String register(){
        return "register";
    }
    @PostMapping(value = "registerSub")
    public String loginSuccess(@RequestParam(value = "ID")String ID,
                               @RequestParam(value = "role") int role,Student student){
        System.out.println(student.getPassword());
        String md5Password = Md5Utils.getMD5_32bits(student.getPassword());
        student.setStudentID(ID);
        student.setPassword(md5Password);
        studentService.insert(student);
        return "success";
    }
    @PostMapping(value = "query")
    public String query(Model model,String ID){
        Student student = studentService.queryByID(ID);
        if(student != null){
            System.out.println(student);
            model.addAttribute("student",student);
            return "success";
        }
        return "error";
    }
    @PostMapping(value="userCheck")
    public String pswCheck(@RequestParam("ID") String ID,
                           @RequestParam(value = "password") String password){

        return null;
    }

    @GetMapping(value = "home")
    public String home(){
        return "home";
    }
}
