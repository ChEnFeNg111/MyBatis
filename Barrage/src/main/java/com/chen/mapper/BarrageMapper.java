package com.chen.mapper;

import com.chen.entity.Barrage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BarrageMapper {
    @Select("select text from barrage")
    public List<Barrage> findBarrage();

    @Insert("insert into barrage values(#{text})")
    public void insertBarrage(String text);
}
