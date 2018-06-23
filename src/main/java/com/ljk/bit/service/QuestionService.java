package com.ljk.bit.service;

import com.ljk.bit.entity.Question;

import java.util.Map;

public interface QuestionService {

    boolean isPass(Map<Integer,String> submit);
}
