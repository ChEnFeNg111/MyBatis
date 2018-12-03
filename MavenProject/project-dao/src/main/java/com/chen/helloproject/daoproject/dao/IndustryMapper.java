package com.chen.helloproject.daoproject.dao;


import com.chen.helloproject.domainproject.domain.Industry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface IndustryMapper {

    @Select("select industryid,industryname,parentid from saas_industry where industryid=#{id}")
    public Industry findById(int id);

}
