package com.ljk.bit.web;

import com.ljk.bit.dto.ResponseData;
import com.ljk.bit.entity.LoginInfo;
import com.ljk.bit.entity.Student;
import com.ljk.bit.service.OrdersService;
import com.ljk.bit.service.TutorService;
import com.ljk.bit.service.serviceImpl.EngineerServiceImpl;
import com.ljk.bit.service.serviceImpl.StudentServiceImpl;
import com.ljk.bit.service.serviceImpl.TutorServiceImpl;
import com.ljk.bit.util.JWT;
import com.ljk.bit.util.Md5Utils;
import com.ljk.bit.vo.StudentOrderView;
import com.ljk.bit.vo.StudentVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private EngineerServiceImpl engineerService;
    @Autowired
    private TutorServiceImpl tutorService;
    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody ResponseData login(@RequestBody LoginInfo loginInfo){
        int role = loginInfo.getRole();
        ResponseData responseData = ResponseData.ok();
        String token = JWT.sign(loginInfo,15L*60L*1000L);
        responseData.putDataValue("token",token);
        switch (role){
            case 3:
                if(studentService.login(loginInfo))
                    return responseData;
                break;
            case 2:
                if(engineerService.login(loginInfo))
                    return responseData;
                break;
            case 1:
                if(tutorService.login(loginInfo))
                    return responseData;
                break;
        }
        return ResponseData.unauthorized();
    }
    @GetMapping(value="register")
    public String register(){
        return "register";
    }
    @PostMapping(value = "registerSub")
    public String loginSuccess(@RequestParam(value = "ID")String ID,
                               @RequestParam(value = "role") int role,StudentVo student){
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

    @GetMapping(value = "/home")
    public String home(Model model,String token){
        LoginInfo loginInfo = JWT.unsign(token,LoginInfo.class);
        model.addAttribute("token",token);
        String userID = loginInfo.getUserID();
        int role = loginInfo.getRole();
        String des = "error";
        if(role == 3){
            List<StudentOrderView> studentOrderViewsList = ordersService.studentOrderView(userID);
            model.addAttribute("ViewsList",studentOrderViewsList);
            System.out.println(studentOrderViewsList);
            des = "studentHome";
        }else if(role == 2){
            des = "engineerHome";
        }else if(role == 1){
            des = "tutorHome";
        }
        return des;
    }
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(String token){
        return "redirect:/index.jsp";
    }

}
