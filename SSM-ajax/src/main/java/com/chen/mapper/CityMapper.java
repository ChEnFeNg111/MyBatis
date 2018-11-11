package com.chen.mapper;


import com.chen.entity.City;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface CityMapper {

    @Select("select region_id,region_name,parent_id from region where parent_id=#{id}")
    public List<City> findById(int id);
}
