package com.steak.controller;

import com.steak.entity.Type;
import com.steak.service.TypeService;
import com.steak.utils.IpUtil;
import com.steak.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/type")
@CrossOrigin(allowCredentials="true")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("/getAll")
    public List<Type> getAll(HttpSession session, HttpServletRequest request){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "获取类型列表");
        return typeService.getAll();
    }

    @RequestMapping("/getById")
    public Type getById(int id,HttpSession session, HttpServletRequest request){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "获取类型id为" + id +"的名称");
        return typeService.getById(id);
    }

}