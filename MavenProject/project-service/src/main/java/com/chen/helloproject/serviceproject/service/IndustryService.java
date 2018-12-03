package com.chen.helloproject.serviceproject.service;


import com.chen.helloproject.daoproject.dao.IndustryMapper;
import com.chen.helloproject.domainproject.domain.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndustryService {

    @Autowired
    private IndustryMapper mapper;

    public Industry findById(int id){
        return mapper.findById(id);
    }

}
