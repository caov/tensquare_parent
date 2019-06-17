package com.tensquare.user.service;

import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;

/**
 * @program: tensquare_parent
 * @description: 用户service层
 * @author: cf
 * @create: 2019-06-17 10:55
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    IdWorker idWorker;
    @Autowired
    BCryptPasswordEncoder encoder;

    public void add(User user) {
        user.setId( idWorker.nextId()+"" );
        //密码加密
        user.setPassword(encoder.encode(user.getPassword()));
        user.setFollowcount(0);//关注数
        user.setFanscount(0);//粉丝数
        user.setOnline(0L);//在线时长
        user.setRegdate(new Date());//注册日期
        user.setUpdatedate(new Date());//更新日期
        user.setLastdate(new Date());//最后登陆日期
        userDao.save(user);
    }

    public User findByMobileAndPassword(String mobile,String password){
        User user = userDao.findByMobile(mobile);
        if (user != null && encoder.matches(password,user.getPassword())){
            return user;
        }else{
            return null;
        }
    }


    public void deleteById(String id) {
        userDao.deleteById(id);
    }
}
