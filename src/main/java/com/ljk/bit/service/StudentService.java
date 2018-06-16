package com.ljk.bit.service;

import com.ljk.bit.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    void insert(Student student);
    Student queryByID(String ID);
    String queryPasswordByID(String ID);
    Student queryByName(String ID);
}
