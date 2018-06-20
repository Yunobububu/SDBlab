package com.ljk.bit.service;

import com.ljk.bit.entity.Student;
import com.ljk.bit.vo.StudentVo;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    void insert(StudentVo student);
    Student queryByID(String ID);
    String queryPasswordByID(String ID);
    Student queryByName(String ID);
}
