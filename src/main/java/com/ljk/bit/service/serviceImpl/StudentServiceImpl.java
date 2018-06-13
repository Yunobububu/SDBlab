package com.ljk.bit.service.serviceImpl;

import com.ljk.bit.dao.StudentDao;
import com.ljk.bit.entity.Student;
import com.ljk.bit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;
    @Override
    public void insert(Student student) {
        studentDao.insert(student);
    }

    @Override
    public Student queryByID(String ID) {
        Student student = studentDao.queryByID(ID);
        return student;
    }
}
