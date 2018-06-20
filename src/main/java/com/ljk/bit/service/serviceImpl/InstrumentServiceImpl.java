package com.ljk.bit.service.serviceImpl;

import com.ljk.bit.dao.InstrumentDao;
import com.ljk.bit.entity.Instrument;
import com.ljk.bit.service.InstrumentService;
import com.ljk.bit.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentServiceImpl implements InstrumentService{
    @Autowired
    private InstrumentDao instrumentDao;
    @Override
    public Instrument queryByID(String ID) {
        return instrumentDao.queryByID(ID);
    }
    public List<Boolean> isPast(){
        return DateUtils.isPast();
    }
}
