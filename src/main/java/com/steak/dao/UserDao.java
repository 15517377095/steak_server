package com.steak.dao;

import com.steak.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    @Select("select * from t_user")
    public List<User> getAll();

    @Insert("insert into t_user(email,password) values(#{email},#{password})")
    public int addOne(User user);

    @Select("select * from t_user where email=#{email} and password=#{password}")
    public User selectOne(User user);

    @Delete("delete from t_user where id=#{id}")
    public int deleteById(int id);
}
