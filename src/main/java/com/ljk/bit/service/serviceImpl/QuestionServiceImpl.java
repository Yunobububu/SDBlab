package com.ljk.bit.service.serviceImpl;

import com.ljk.bit.dao.QuestionDao;
import com.ljk.bit.entity.Question;
import com.ljk.bit.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionDao questionDao;
    @Override
    public boolean isPass(Map<Integer, String> submit) {
        int count = 0;
        for(Integer i : submit.keySet()){
            Question question = questionDao.queryByID(i);
            if(submit.get(i).equals(question.getAnswer())){
                count++;
            }
        }
        return count >= 18 ? true : false;
    }

    public boolean isPass(List<Question> submit){
        int count = 0;
        for(Question sub : submit){
            Question answer = questionDao.queryByID(sub.getQuestionID());
            if(sub.getAnswer().equals(answer.getAnswer())){
                count++;
            }
        }
        return count >= 18 ? true : false;
    }
}
