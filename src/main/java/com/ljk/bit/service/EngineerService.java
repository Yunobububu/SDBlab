package com.ljk.bit.service;

import com.ljk.bit.entity.Engineer;
import com.ljk.bit.entity.LoginInfo;

public interface EngineerService {
    Engineer queryByID(String ID);
    boolean login(LoginInfo loginInfo);
}
