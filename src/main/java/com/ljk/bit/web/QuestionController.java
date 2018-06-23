package com.ljk.bit.web;

import com.ljk.bit.dto.ResponseData;
import com.ljk.bit.entity.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class QuestionController {
    @RequestMapping(value = "answer",method = RequestMethod.POST)
    public @ResponseBody ResponseData answer(@RequestBody Map<String,Question> subMap){
        System.out.println(subMap);
        for(Question question: subMap.values()){
            System.out.println(question.getSubmit());
        }
        return ResponseData.ok();
    }
}
