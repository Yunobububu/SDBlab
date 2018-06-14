package com.ljk.bit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TestController {
    @GetMapping(value = "testJquery")
    public String testJquery(){
        return "jquery";
    }
    @PostMapping(value = "Json")
    @ResponseBody
    public String testJson(@RequestBody Map<String,String> map){
        String name = map.get("name");
        return name;
    }

}
