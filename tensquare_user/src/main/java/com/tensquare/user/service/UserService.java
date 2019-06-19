package com.tensquare.user.service;

import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedisTemplate redisTemplate;

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

    @Transactional
    public void updatefanscountandfollowcount(int x, String userid, String friendid) {
        userDao.updatefanscount(x, friendid);
        userDao.updatefollowcount(x, userid);
    }

    public void sendSms(String mobile) {
        //生成六位数字随机数
        String checkcode = RandomStringUtils.randomNumeric(6);
        //向缓存中放一份
        redisTemplate.opsForValue().set("checkcode_"+mobile, checkcode, 6, TimeUnit.HOURS);
        //给用户发一份
        Map<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("checkcode", checkcode);
        //rabbitTemplate.convertAndSend("sms", map);
        //在控制台显示一份【方便测试】
        System.out.println("验证码为："+checkcode);
    }
}
