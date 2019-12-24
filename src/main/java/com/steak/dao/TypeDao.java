package com.steak.dao;

import com.steak.entity.Type;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TypeDao {
    @Select("select * from t_type")
    List<Type> getAll();

    @Select("select name from t_type where id=#{id}")
    Type getById(int id);
}
