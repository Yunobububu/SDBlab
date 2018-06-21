package com.ljk.bit.dao;

import com.ljk.bit.entity.Tutor;
import org.apache.ibatis.annotations.Param;

public interface TutorDao {
    Tutor queryByID(@Param("tutorID") String tutorID);
    void insert(@Param("tutor") Tutor tutor);
    Tutor queryByName(@Param("tutorName") String tutorName);
}
