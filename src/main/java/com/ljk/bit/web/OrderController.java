package com.ljk.bit.web;

import com.ljk.bit.dto.ResponseData;
import com.ljk.bit.entity.LoginInfo;
import com.ljk.bit.entity.Orders;
import com.ljk.bit.entity.PagingInfo;
import com.ljk.bit.service.serviceImpl.OrdersServiceImpl;
import com.ljk.bit.util.DateUtil;
import com.ljk.bit.util.JWT;
import com.ljk.bit.vo.EngineerOrderView;
import com.ljk.bit.vo.StudentOrderView;
import com.ljk.bit.vo.TutorOrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/order/")
public class OrderController {
    @Autowired
    private OrdersServiceImpl ordersService;
    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String  order(RedirectAttributes  model, String token, int day,
                         String time,String instrumentID){
        LoginInfo info = JWT.unsign(token,LoginInfo.class);
        String userID = info.getUserID();
        ordersService.insert(day,time,instrumentID,userID);
        model.addAttribute("token",token);
        return "redirect:/home";
    }
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String deleteOrderByID(long orderID, String token, RedirectAttributes model){
        model.addAttribute("token",token);
        ordersService.deleteByID(orderID);
        return "redirect:/home";
    }
    @RequestMapping(value = "queryOrdersInWeek",method = RequestMethod.GET)
    public String queryOrdersInWeek(Model model,String token){
        model.addAttribute("token",token);
        List<EngineerOrderView> viewsList =
                ordersService.queryOrdersInWeek(DateUtil.MonEight(),DateUtil.FriSeventeen());
        model.addAttribute("viewsList",viewsList);
        return "ordersInWeek";
    }
    /*
        审核通过
     */
    @RequestMapping(value = "pass",method = RequestMethod.GET)
    public String pass(String token,Model model ,long orderID){
        ordersService.pass(orderID);
        model.addAttribute("token",token);
        List<EngineerOrderView> viewsList =
                ordersService.queryOrdersInWeek(DateUtil.MonEight(),DateUtil.FriSeventeen());
        model.addAttribute("viewsList",viewsList);
        return "ordersInWeek";
    }
    @RequestMapping(value = "exportExcel",method = RequestMethod.GET)
    public @ResponseBody String exportExcel(HttpServletResponse response,String tutorID){
        response.setContentType("application/binary;charset=UTF-8");
        try {
            ServletOutputStream out =  response.getOutputStream();
            String fileName=new String(("OrderInfo "+
                    new SimpleDateFormat("yyyy-MM-dd").
                            format(new Date())).getBytes(),"UTF-8");
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
            String[] titles = { "预约人", "预约仪器", "开始时间", "结束时间","费用"};
            ordersService.export(titles,out,tutorID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
    @RequestMapping(value = "tutorView",method = RequestMethod.POST)
    public @ResponseBody ResponseData tutorView(@RequestBody PagingInfo pagingInfo){
        String tutorID = pagingInfo.getUserID();
        List<TutorOrderView> orderViews = ordersService.queryOrdersForTutors(tutorID);
        //每页显示5条,
        int pages = orderViews.size() % 2 != 0 ? (orderViews.size() / 2 + 1) : orderViews.size()/2;
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("pages",pages);
        responseData.putDataValue("orderViews",orderViews);
        responseData.putDataValue("total",orderViews.size());
        responseData.putDataValue("currentPage",pagingInfo.getPage());
        System.out.println(responseData);
        return responseData;
    }
}
