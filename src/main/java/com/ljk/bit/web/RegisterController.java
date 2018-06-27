package com.ljk.bit.web;

import com.ljk.bit.entity.Engineer;
import com.ljk.bit.entity.Register;
import com.ljk.bit.entity.Student;
import com.ljk.bit.entity.Tutor;
import com.ljk.bit.service.StudentService;
import com.ljk.bit.service.TutorService;
import com.ljk.bit.service.serviceImpl.EngineerServiceImpl;
import com.ljk.bit.service.serviceImpl.StudentServiceImpl;
import com.ljk.bit.service.serviceImpl.TutorServiceImpl;
import com.ljk.bit.util.Md5Utils;
import com.ljk.bit.dto.ResponseData;
import com.ljk.bit.validators.ValidatorRegisterGroup;
import com.ljk.bit.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private EngineerServiceImpl engineerService;
    @Autowired
    private TutorServiceImpl tutorService;
    @Autowired
    private StudentVo student;
    @Autowired
    private Engineer engineer;
    @Autowired
    private Tutor tutor;
    @PostMapping(value = "registerIDCheck" )
    public @ResponseBody ResponseData IDCheck(@Validated @RequestBody Register register,
                                              BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            for(ObjectError error:errors){
                System.out.println(error.getDefaultMessage());
            }
        }
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
            if(tutorService.isIDExist(ID))
                return ResponseData.alreadyExist();
        }
        return ResponseData.ok();
    }
    @PostMapping(value = "registerUserNameCheck")
    public @ResponseBody ResponseData nameCheck(@Validated(value = {ValidatorRegisterGroup.class})@RequestBody Register register,
                                                BindingResult bindingResult){
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
            if(tutorService.isNameExist(register.getUserName()))
                return ResponseData.alreadyExist();
        }
        return ResponseData.ok();
    }
    /*
     *学生角色为3,工程师角色为2,指导老师角色为1
     */
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
            engineer.setName(userName);
            engineer.setPassword(password);
            engineer.setEngineerID(userID);
            engineer.setRole(role);
            engineerService.insert(engineer);
        }else if(role == 1){
            tutor.setTutorID(userID);
            tutor.setPassword(password);
            tutor.setEmail(email);
            tutor.setRole(role);
            tutor.setTutorName(userName);
            tutorService.insert(tutor);
        }
        return ResponseData.ok();
    }
}
