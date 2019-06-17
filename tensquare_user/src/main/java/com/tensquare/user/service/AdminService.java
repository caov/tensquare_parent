package com.tensquare.user.service;

import com.tensquare.user.dao.AdminDao;
import com.tensquare.user.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import util.IdWorker;

/**
 * @program: tensquare_parent
 * @description: 管理员Service层
 * @author: cf
 * @create: 2019-06-17 10:56
 */
@Service
public class AdminService {
    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    IdWorker idWorker;
    @Autowired
    AdminDao adminDao;

    public void add(Admin admin){
        admin.setId(idWorker.nextId()+"");//主键值
        admin.setPassword(encoder.encode(admin.getPassword()));//密码加密
        adminDao.save(admin);
    }

    public Admin findByLoginnameAndPassword(String loginname,String password){
        Admin admin = adminDao.findByLoginname(loginname);
        if (admin != null && encoder.matches(password,admin.getPassword())){
            return  admin;
        }else{
            return null;
        }
    }
}
