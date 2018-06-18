package com.ljk.bit.web;

import com.ljk.bit.entity.Engineer;
import com.ljk.bit.entity.Register;
import com.ljk.bit.entity.Student;
import com.ljk.bit.service.StudentService;
import com.ljk.bit.service.serviceImpl.EngineerServiceImpl;
import com.ljk.bit.service.serviceImpl.StudentServiceImpl;
import com.ljk.bit.util.Md5Utils;
import com.ljk.bit.dto.ResponseData;
import com.ljk.bit.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private EngineerServiceImpl engineerService;
    @Autowired
    private StudentVo student;
    @Autowired
    private Engineer engineer;
    @Autowired
    @PostMapping(value = "registerIDCheck" )
    public @ResponseBody ResponseData IDCheck(@RequestBody Register register){
        System.out.println(register);
        String ID = register.getUserID();
        int role = register.getRole();
        if(role == 3){
            if(studentService.isExist(ID)){
                return ResponseData.alreadyExist();
            }
        }else if(role == 2){
            if(engineerService.isExist(ID)){
                return ResponseData.alreadyExist();
            }
        }else if(role == 1){
        }
        return ResponseData.ok();
    }
    @PostMapping(value = "registerUserNameCheck")
    public @ResponseBody ResponseData nameCheck(@RequestBody Register register){
        //System.out.println(register);
        int role = register.getRole();
        if(role == 3){
            if(studentService.isNameExist(register.getUserName())){
                return ResponseData.alreadyExist();
            }
        }else if (role == 2){
            if (engineerService.isNameExist(register.getUserName())){
                return ResponseData.alreadyExist();
            }
        }else if(role == 1){

        }
        return ResponseData.ok();
    }
    @PostMapping(value = "registerUpdate")
    public @ResponseBody ResponseData registerUpdate(@RequestBody Register register){
        int role = register.getRole();
        String userName = register.getUserName();
        String password = Md5Utils.getMD5_32bits(register.getPassword());
        String userID = register.getUserID();
        String email = register.getEmail();
        if(role == 3){
            student.setPassword(password);
            student.setStudentID(userID);
            student.setEmail(email);
            student.setName(userName);
            student.setRole(role);
            studentService.insert(student);
        }else if(role == 2){
            engineer.setEmail(email);
            engineer.setEngineerID(userID);
            engineer.setName(userName);
            engineer.setPassword(password);
            engineer.setEngineerID(userID);
            engineer.setRole(role);
            engineerService.insert(engineer);
        }
        return ResponseData.ok();
    }
}
