package com.ljk.bit.service.serviceImpl;

import com.ljk.bit.dao.EngineerDao;
import com.ljk.bit.entity.Engineer;
import com.ljk.bit.entity.LoginInfo;
import com.ljk.bit.service.EngineerService;
import com.ljk.bit.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EngineerServiceImpl implements EngineerService{
    @Autowired
    private EngineerDao engineerDao;
    @Override
    public Engineer queryByID(String ID) {
        Engineer engineer = engineerDao.queryByID(ID);
        return engineer;
    }

    @Override
    public boolean login(LoginInfo loginInfo) {
        Engineer engineer = queryByID(loginInfo.getUserID());
        if(engineer != null){
            String password = queryByID(loginInfo.getUserID()).getPassword();
            String md5psw = Md5Utils.getMD5_32bits(loginInfo.getPassword());
            return password.equals(md5psw) ? true : false;
        }
        return false;
    }

    public boolean isExist(String ID){
        Engineer engineer = queryByID(ID);
        return (engineer != null) ? true : false;
    }
    public Engineer queryByName(String name){
        Engineer engineer = engineerDao.queryByName(name);
        return engineer;
    }
    public boolean isNameExist(String name){
        Engineer engineer = queryByName(name);
        return (engineer != null) ? true : false;
    }
    public void insert(Engineer engineer){
        engineerDao.insertOrUpdate(engineer);
    }

}
