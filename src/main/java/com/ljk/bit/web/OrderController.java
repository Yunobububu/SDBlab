package com.ljk.bit.web;

import com.ljk.bit.dto.ResponseData;
import com.ljk.bit.entity.Orders;
import com.ljk.bit.service.serviceImpl.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    @Autowired
    private OrdersServiceImpl ordersService;
    @RequestMapping(value = "order",method = RequestMethod.GET)
    public String  order(Model model, String token, int day,
                         String time,String instrumentID){
        ordersService.insert(day,time,instrumentID);
        model.addAttribute("token",token);
        return "home";
    }
}
