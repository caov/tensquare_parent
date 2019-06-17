package com.tensquare.user.controller;

import com.tensquare.user.pojo.Admin;
import com.tensquare.user.service.AdminService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: tensquare_parent
 * @description: 管理员控制类
 * @author: cf
 * @create: 2019-06-17 11:12
 */
@RestController
@CrossOrigin
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    JwtUtil jwtUtil;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Result login(@RequestBody Map<String,String> map){
        Admin admin = adminService.findByLoginnameAndPassword(map.get("loginname"),map.get("password"));
        if (admin != null){
            String token = jwtUtil.createJWT(admin.getId(),admin.getLoginname(),"admin");
            Map resultMap = new HashMap();
            resultMap.put("token",token);
            resultMap.put("name",admin.getLoginname());
            return new Result(true, StatusCode.OK,"登录成功",resultMap);
        }else{
            return  new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
        }
    }
}
