package com.steak.controller;

import com.steak.entity.Shop;
import com.steak.service.ShopService;
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
@RequestMapping("/shop")
@CrossOrigin(allowCredentials="true")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping("/gatByUserId")
    public List<Shop> gatByUserId(int id, HttpSession session, HttpServletRequest request){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "获取用户Id为" + id + "的购物车列表");
        return shopService.selectByUserId(id);
    }

    @RequestMapping("/addOne")
    public Boolean addOne(int userId,int gameId,HttpSession session, HttpServletRequest request){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "用户Id为" + userId + "向购物车添加了" + gameId);
        return shopService.addOne(userId, gameId);
    }

    @RequestMapping("/deleteById")
    public int deleteById(int id,HttpSession session, HttpServletRequest request){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "移除购物车游戏" + id);
        return shopService.deleteById(id);
    }

}
