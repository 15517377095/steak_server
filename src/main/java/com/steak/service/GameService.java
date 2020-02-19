package com.steak.service;

import com.steak.dao.GameDao;
import com.steak.entity.Game;
import com.steak.utils.IpUtil;
import com.steak.utils.Log;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameDao gameDao;

    @Autowired
    private UtilService utilService;

    public List<Game> getIndexScrollInfo(){
        return gameDao.getIndexScrollInfo();
    }

    public List<Game> getIndexNewInfo(){
        return gameDao.getIndexNewInfo();
    }

    public List<Game> getByType(int type){
        return gameDao.getByType(type);
    }

    public List<Game> getAllFree(){
        return gameDao.getAllFree();
    }

    public List<Game> getAllOrderByNew(){
        return gameDao.getAllOrderByNew();
    }

    public List<Game> getAll(){
        return gameDao.getAll();
    }

    public Game getById(int id){
        return gameDao.getById(id);
    }

    public int deleteById(int id){
        File dir = new File(System.getProperty("user.dir") + "/images/");
        File[] files = dir.listFiles();
        for(int i = 0 ; i < files.length ; i++){
            if(files[i].getName().indexOf(id + "-") != -1){
                // log
                utilService.printNowTime();
                System.out.println("随ID删除(deleteById)：" + files[i].getName());
                files[i].delete();
            }
        }
        return gameDao.deleteById(id);
    }

    public int insertOne(Game game){
        return gameDao.insertOne(game);
    }

    public int editOne(Game game){
        return gameDao.editOne(game);
    }

    public void deleteImgByName(String filename){
        String path = System.getProperty("user.dir") + "/images/" + filename;
        File file = new File(path);
        file.delete();
        // log
        utilService.printNowTime();
        System.out.println("手动删除(deleteImgByName)：" + file.getName());
    }

    public void deleteImgsByAutoId(){
        String autoId = String.valueOf(gameDao.getAutoIncrementId());
        File dir = new File(System.getProperty("user.dir") + "/images/");
        File[] files = dir.listFiles();
        for(int i = 0 ; i < files.length ; i++){
            if(files[i].getName().indexOf(autoId + "-") != -1){
                // log
                utilService.printNowTime();
                System.out.println("放弃表单(deleteImgsByAutoId)：" + files[i].getName());
                files[i].delete();
            }
        }
    }

    public String saveImage(MultipartFile multipartFile, HttpSession session, HttpServletRequest request){
        int begin = multipartFile.getOriginalFilename().indexOf(".");
        int last = multipartFile.getOriginalFilename().length();
        String fileType = multipartFile.getOriginalFilename().substring(begin, last);

        int autoIncrementId=gameDao.getAutoIncrementId();

        String fileName = RandomStringUtils.randomAlphanumeric(10) + fileType;
        String filePath = System.getProperty("user.dir") + "/images/" + autoIncrementId + "-" + fileName;

        System.out.println("------------------" + filePath);

        InputStream inputStream = null;   //获取到文件
        try {
            inputStream = multipartFile.getInputStream();
            FileOutputStream fileOut = new FileOutputStream(new File(filePath));
            byte[] buf = new byte[1024 * 8];
            while (true) {
                int read = 0;
                if (inputStream != null) {
                    read = inputStream.read(buf);
                }
                if (read == -1) {
                    break;
                }
                fileOut.write(buf, 0, read);
            }
            fileOut.flush();
            if (fileOut.getFD().valid() == true) {
                // log
                utilService.printNowTime();
                String fwqpath="http://101.200.132.176:888/images/" + autoIncrementId + "-" + fileName;
                Log.logger.warn(IpUtil.getIpAddr(request) + " - " + session.getId() + " - " +
                        "上传图片[" + fwqpath + "]");
                return fwqpath;
            } else {
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
