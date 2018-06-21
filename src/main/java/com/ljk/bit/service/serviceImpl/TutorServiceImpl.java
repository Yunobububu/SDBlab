package com.ljk.bit.service.serviceImpl;

import com.ljk.bit.dao.TutorDao;
import com.ljk.bit.entity.LoginInfo;
import com.ljk.bit.entity.Tutor;
import com.ljk.bit.service.TutorService;
import com.ljk.bit.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorServiceImpl implements TutorService{
    @Autowired
    private TutorDao tutorDao;
    @Override
    public Tutor queryByID(String tutorID) {
        return tutorDao.queryByID(tutorID);
    }

    @Override
    public void insert(Tutor tutor) {
        tutorDao.insert(tutor);
    }

    @Override
    public boolean login(LoginInfo loginInfo) {
        Tutor tutor = queryByID(loginInfo.getUserID());
        if(tutor != null){
            String password = tutor.getPassword();
            String md5psw = Md5Utils.getMD5_32bits(loginInfo.getPassword());
            return (password.equals(md5psw)) ? true : false;
        }
        return false;
    }

    @Override
    public boolean isNameExist(String tutorName) {
        Tutor tutor = tutorDao.queryByName(tutorName);
        return tutor != null ? true :false;
    }

    @Override
    public boolean isIDExist(String tutorID) {
        Tutor tutor = tutorDao.queryByID(tutorID);
        return tutor != null ? true : false;
    }


}
