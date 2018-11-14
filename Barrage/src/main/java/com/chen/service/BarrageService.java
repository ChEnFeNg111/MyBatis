package com.chen.service;

import com.chen.entity.Barrage;
import com.chen.mapper.BarrageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarrageService {

    @Autowired
    private BarrageMapper mapper;

    public List<Barrage> findBarrage(){
        return  mapper.findBarrage();
    }

    public void insertBarrage(String text){
        mapper.insertBarrage(text);

    }
}
