package com.steak.controller;

import com.steak.entity.Game;
import com.steak.service.GameService;
import com.steak.utils.IpUtil;
import com.steak.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/game")
@CrossOrigin(allowCredentials="true")
public class GameController{

    @Autowired
    private GameService gameService;

    @RequestMapping("/getIndexScrollInfo")
    public List<Game> getIndexScrollInfo(HttpServletRequest request,HttpSession session){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "获取首页滚屏游戏列表");
        return gameService.getIndexScrollInfo();
    }

    @RequestMapping("/getIndexNewInfo")
    public List<Game> getIndexNewInfo(HttpServletRequest request,HttpSession session){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "获取首页最新游戏列表");
        return gameService.getIndexNewInfo();
    }

    @RequestMapping("/getByType")
    public List<Game> getByType(int type,HttpServletRequest request,HttpSession session){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "获取类型为" + type + "的游戏列表");
        return gameService.getByType(type);
    }

    @RequestMapping("/getAllFree")
    public List<Game> getAllFree(HttpServletRequest request,HttpSession session){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "获取免费游戏列表");
        return gameService.getAllFree();
    }

    @RequestMapping("/getAllOrderByNew")
    public List<Game> getAllOrderByNew(HttpServletRequest request,HttpSession session){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "获取最新游戏列表");
        return gameService.getAllOrderByNew();
    }

    @RequestMapping("/getAll")
    public List<Game> getAll(HttpServletRequest request,HttpSession session){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "获取所有游戏列表");
        return gameService.getAll();
    }

    @RequestMapping("/getById")
    public Game getById(int id,HttpServletRequest request,HttpSession session){
        Log.logger.info(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "获取id为" + id + "的游戏详情信息");
        return gameService.getById(id);
    }

    @RequestMapping("/deleteById")
    public int deleteById(int id,HttpServletRequest request,HttpSession session){
        Log.logger.warn(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "删除id为" + id + "的游戏");
        return gameService.deleteById(id);
    }

    @RequestMapping("/saveImage")
    public String saveImage(MultipartFile multipartFile,HttpServletRequest request,HttpSession session){
        return gameService.saveImage(multipartFile,session,request);
    }

    @RequestMapping("/deleteImgByName")
    public void deleteImgByName(String name,HttpServletRequest request,HttpSession session){
        Log.logger.warn(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "删除名字为" + name + "的图片");
        gameService.deleteImgByName(name);
    }

    @RequestMapping("/deleteImgsByAutoId")
    public void deleteImgsByAutoId(HttpServletRequest request,HttpSession session){
        Log.logger.warn(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "删除自增长ID图片");
        gameService.deleteImgsByAutoId();
    }

    @RequestMapping("/insertOne")
    public void insertOne(@RequestBody Game game,HttpServletRequest request,HttpSession session){
        Log.logger.warn(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                "添加游戏" + game.getName());
        gameService.insertOne(game);
    }

    @RequestMapping("/editOne")
    public void editOne(@RequestBody Game game,HttpServletRequest request,HttpSession session){
        gameService.editOne(game);
    }

}
