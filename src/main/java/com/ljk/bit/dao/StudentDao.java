package com.ljk.bit.dao;

import com.ljk.bit.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface StudentDao {
    Student queryByID(@Param("ID") String ID);
    boolean insert(@Param("student") Student student);
    String queryPasswordByID(@Param("ID") String ID);
    Student queryByName(@Param("ID") String ID);
}
