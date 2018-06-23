package com.ljk.bit.dao;

import com.ljk.bit.entity.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface QuestionDao {
    Question queryByID(@Param("questionID")int questionID);
}
