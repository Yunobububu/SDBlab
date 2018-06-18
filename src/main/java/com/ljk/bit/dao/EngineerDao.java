package com.ljk.bit.dao;

import com.ljk.bit.entity.Engineer;
import org.apache.ibatis.annotations.Param;

public interface EngineerDao {
    Engineer queryByID(@Param("ID") String ID);
    Engineer queryByName(@Param("name") String name);
    void insertOrUpdate(@Param("engineer") Engineer engineer);
    boolean deleteByID(@Param("ID")String ID);
}
