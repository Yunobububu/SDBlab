package com.ljk.bit.service;

import com.ljk.bit.entity.Instrument;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public interface InstrumentService {
    Instrument queryByID(String ID);
}
