package com.steak.dao;

import com.steak.entity.Shop;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ShopDao {
    public List<Shop> selectByUserId(int id);

    @Delete("delete from t_shop where id=#{id}")
    public int deleteById(int id);

    @Select("select * from t_shop where game=#{game} and user=#{user}")
    public List<Shop> selectByUserAndGame(int user,int game);

    @Insert("insert into t_shop(game,user) values(#{game},#{user})")
    public void addOne(int user,int game);
}
