package com.ljk.bit.dao;

import com.ljk.bit.entity.Instrument;
import org.apache.ibatis.annotations.Param;

public interface InstrumentDao {

    Instrument queryByID(@Param("ID") String ID);
}
