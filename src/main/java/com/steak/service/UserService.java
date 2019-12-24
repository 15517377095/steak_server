package com.steak.service;

import com.steak.dao.UserDao;
import com.steak.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public int addUser(User user){
        return userDao.addOne(user);
    }

    public User login(User user){return userDao.selectOne(user);}

}
