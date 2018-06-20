package com.ljk.bit.web;

import com.ljk.bit.dto.ResponseData;
import com.ljk.bit.entity.Instrument;
import com.ljk.bit.entity.LoginInfo;
import com.ljk.bit.service.serviceImpl.InstrumentServiceImpl;
import com.ljk.bit.service.serviceImpl.OrdersServiceImpl;
import com.ljk.bit.util.DateUtils;
import com.ljk.bit.util.JWT;
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
@RequestMapping(value = "/home")
public class HomeController {
    @Autowired
    private InstrumentServiceImpl instrumentService;
    @Autowired
    private OrdersServiceImpl ordersService;
    public @ResponseBody ResponseData myOrder(String token){
        LoginInfo loginInfo = JWT.unsign(token, LoginInfo.class);
        return ResponseData.unauthorized();
    }
    @RequestMapping(value = "CVD",method = RequestMethod.GET)
    public String VCD(Model model , String token,String instrumentID){
        Instrument instrument = instrumentService.queryByID(instrumentID);
        model.addAttribute("instrument",instrument);
        model.addAttribute("isPast", instrumentService.isPast());
        model.addAttribute("isOrdered",ordersService.isOrdered());
//        List<Map<String,LocalDateTime>> ordered =
//                ordersService.queryOrderedMap(DateUtils.MonEight(),DateUtils.FriSeventeen());
//        List<LocalDateTime> ordered = ordersService.queryStartTimeList(
//                DateUtils.MonEight(),DateUtils.FriSeventeen());
//        System.out.println(ordered);
//        List<Boolean> isOrdered = ordersService.isOrdered();
//        System.out.println(isOrdered);
        return "CVD";
    }


}
