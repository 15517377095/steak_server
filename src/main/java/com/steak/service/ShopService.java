package com.steak.service;

import com.steak.dao.ShopDao;
import com.steak.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopDao shopDao;

    public List<Shop> selectByUserId(int id){
        return shopDao.selectByUserId(id);
    }

    public Boolean addOne(int userId, int gameId){
        if(!shopDao.selectByUserAndGame(userId, gameId).isEmpty()){    //若存在,不添加
            return false;   //返回false
        }
        shopDao.addOne(userId, gameId); //若不存在,添加
        return true;    //返回true
    }

    public int deleteById(int id){
        return shopDao.deleteById(id);
    }

}