package com.steak.dao;

import com.steak.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    @Insert("insert into t_user(email,password) values(#{email},#{password})")
    public int addOne(User user);

    @Select("select * from t_user where email=#{email} and password=#{password}")
    public User selectOne(User user);
}
