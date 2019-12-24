package com.steak.service;

import com.steak.dao.TypeDao;
import com.steak.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeDao typeDao;

    public List<Type> getAll(){
        return typeDao.getAll();
    }

    public Type getById(int id){
        return typeDao.getById(id);
    }
}
