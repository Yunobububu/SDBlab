package com.ljk.bit.service;

import com.ljk.bit.entity.LoginInfo;
import com.ljk.bit.entity.Tutor;

public interface TutorService {
    Tutor queryByID(String tutorID);
    void insert(Tutor tutor);
    boolean login(LoginInfo loginInfo);
    boolean isNameExist(String tutorName);
    boolean isIDExist(String tutorID);
}
