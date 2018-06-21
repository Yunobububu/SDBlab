package com.ljk.bit.web;

import com.ljk.bit.dto.ResponseData;
import com.ljk.bit.entity.Instrument;
import com.ljk.bit.entity.LoginInfo;
import com.ljk.bit.service.serviceImpl.InstrumentServiceImpl;
import com.ljk.bit.service.serviceImpl.OrdersServiceImpl;
import com.ljk.bit.util.DateUtils;
import com.ljk.bit.util.JWT;
import com.ljk.bit.vo.StudentOrderView;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home/")
public class HomeController {
    @Autowired
    private InstrumentServiceImpl instrumentService;
    @Autowired
    private OrdersServiceImpl ordersService;

    @RequestMapping(value = "CVD",method = RequestMethod.GET)
    public String CVD(Model model , String token,String instrumentID){
        Instrument instrument = instrumentService.queryByID(instrumentID);
        model.addAttribute("instrument",instrument);
        model.addAttribute("isPast", instrumentService.isPast());
        model.addAttribute("isOrdered",ordersService.isOrdered());
        return "CVD";
    }
    @RequestMapping(value = "Polisher",method = RequestMethod.GET)
    public String polisher(Model model,String token,String instrumentID){

        return "Polisher";
    }
    @RequestMapping(value = "myOrder",method = RequestMethod.GET)
    public String myOrder(Model model,String token){
        LoginInfo loginInfo = JWT.unsign(token,LoginInfo.class);
        String userID = loginInfo.getUserID();
        List<StudentOrderView> studentOrderViewsList = ordersService.studentOrderView(userID);
        model.addAttribute("ViewsList",studentOrderViewsList);
        model.addAttribute("token",token);
        System.out.println(studentOrderViewsList);
        return "myOrder";
    }


}
