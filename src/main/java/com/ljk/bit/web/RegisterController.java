package com.ljk.bit.web;

import com.ljk.bit.entity.Register;
import com.ljk.bit.entity.Student;
import com.ljk.bit.service.StudentService;
import com.ljk.bit.util.Md5Utils;
import com.ljk.bit.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private Student student;
    @PostMapping(value = "registerIDCheck" )
    public @ResponseBody ResponseData IDCheck(@RequestBody Map<String,String> map){
        String ID = null;
        Student student = null;
        int role = -1;
        if(map.containsKey("role")){
            role = Integer.parseInt(map.get("role"));
        }
        if(map.containsKey("ID")){
            ID = map.get("ID");
            if(ID != null){
                if(role == 3){
                    student = studentService.queryByID(ID);
                    if(student == null)
                    return null;
                }
            }
        }
        return ResponseData.ok();
    }
    @PostMapping(value = "registerUserNameCheck")
    public @ResponseBody ResponseData nameCheck(@RequestBody Register register){
        //System.out.println(register);
        if(register.getRole() == 3){
            Student student = studentService.queryByName(register.getUserName());
            if(student == null){
                return null;
            }
        }
        return ResponseData.ok();
    }
    @PostMapping(value = "registerUpdate")
    public @ResponseBody ResponseData registerUpdate(@RequestBody Register register){
        int role = -1;
        role = register.getRole();
        if(role == 3){
            student.setPassword(Md5Utils.getMD5_32bits(register.getPassword()));
            student.setStudentID(register.getUserID());
            student.setEmail(register.getEmail());
            student.setName(register.getUserName());
            System.out.println(student);
            studentService.insert(student);
        }
        return ResponseData.ok();
    }
}
