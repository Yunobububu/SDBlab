package com.ljk.bit.service.serviceImpl;

import com.ljk.bit.dao.StudentDao;
import com.ljk.bit.entity.LoginInfo;
import com.ljk.bit.entity.Student;
import com.ljk.bit.service.StudentService;
import com.ljk.bit.util.Md5Utils;
import com.ljk.bit.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;
    @Override
    public void insert(StudentVo student) {
        studentDao.insert(student);
    }

    @Override
    public Student queryByID(String ID) {
        Student student = studentDao.queryByID(ID);
        return student;
    }

    @Override
    public String queryPasswordByID(String ID) {
        String password = studentDao.queryPasswordByID(ID);
        return password;
    }

    @Override
    public Student queryByName(String ID) {
        Student student = studentDao.queryByName(ID);
        return student;
    }
    public boolean isExist(String ID){
        Student student = studentDao.queryByID(ID);
        return (student != null) ? true : false;
    }
    public boolean isNameExist(String name){
        Student student = studentDao.queryByName(name);
        return (student != null) ? true : false;
    }
    public boolean login(LoginInfo login){
        String ID = login.getUserID();
        Student student = studentDao.queryByID(ID);
        String password = studentDao.queryPasswordByID(ID);
        String md5psw = Md5Utils.getMD5_32bits(login.getPassword());
        if(student != null){
            return (md5psw.equals(student.getPassword())) ? true : false;
        }
        return false;
    }
}
