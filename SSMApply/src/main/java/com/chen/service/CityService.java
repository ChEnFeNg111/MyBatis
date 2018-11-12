package com.chen.service;

import com.chen.entity.City;
import com.chen.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityMapper mapper;

    public List<City> findById(int parent_id){
        return mapper.findById(parent_id);
    }
}
