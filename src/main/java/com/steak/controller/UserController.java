package com.steak.controller;

import com.steak.entity.User;
import com.steak.service.UserService;
import com.steak.utils.IpUtil;
import com.steak.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials="true")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public int addUser(User user,HttpSession session,HttpServletRequest request){
        Log.logger.warn(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "新增用户：" + user);
        return userService.addUser(user);
    }

    @RequestMapping("/login")
    public User login(User user, HttpSession session, HttpServletRequest request){
        User loginUser=userService.login(user);
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "用户登录：" + user);
        session.setAttribute("loginUser",loginUser);
        return loginUser;
    }

    @RequestMapping("/getLoginUser")
    public User getLoginUser(HttpSession session, HttpServletRequest request){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "获取登录状态");
        return (User)session.getAttribute("loginUser");
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session, HttpServletRequest request){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "退出登录");
        session.removeAttribute("loginUser");
    }

}
