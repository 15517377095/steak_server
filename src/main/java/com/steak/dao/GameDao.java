package com.steak.dao;

import com.steak.entity.Game;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GameDao {
    public List<Game> getIndexScrollInfo();
    public List<Game> getIndexNewInfo();
    public List<Game> getByType(int type);
    public List<Game> getAllFree();
    public List<Game> getAllOrderByNew();
    public List<Game> getAll();
    public Game getById(int id);

    @Delete("delete from t_game where id=#{id}")
    public int deleteById(int id);

    @Insert("insert into t_game values(null,#{name},#{typeId},#{money},#{releasedate},#{developers},#{publisher},#{language},#{introduction},#{imgs},#{mdfile})")
    public int insertOne(Game game);

    @Update("update t_game set name = #{name},type = #{typeId},money = #{money},releasedate = #{releasedate},developers = #{developers},publisher = #{publisher},language = #{language},introduction = #{introduction},imgs = #{imgs},mdfile = #{mdfile} where id = #{id}")
    public int editOne(Game game);

    @Select("SELECT auto_increment FROM information_schema.tables where table_schema='steak' and table_name='t_game'")
    public int getAutoIncrementId();
}
