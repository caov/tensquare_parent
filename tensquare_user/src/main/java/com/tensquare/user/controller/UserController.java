package com.tensquare.user.controller;

import com.tensquare.user.pojo.Admin;
import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: tensquare_parent
 * @description: 用户控制类
 * @author: cf
 * @create: 2019-06-17 10:54
 */
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    HttpServletRequest request;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    JwtUtil jwtUtil;

    /**
     * 更新好友粉丝数和用户关注数
     * @return
     */
    @RequestMapping(value = "/{userid}/{friendid}/{x}", method = RequestMethod.PUT)
    public void updatefanscountandfollowcount(@PathVariable String userid, @PathVariable String friendid, @PathVariable int x){
        userService.updatefanscountandfollowcount(x, userid, friendid);
    }

    /**
     * 发送短信验证码
     */
    @RequestMapping(value = "/sendsms/{mobile}", method = RequestMethod.POST)
    public Result sendSms(@PathVariable String mobile){
        userService.sendSms(mobile);
        return new Result(true, StatusCode.OK, "发送成功");
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "/register/{code}", method = RequestMethod.POST)
    public Result regist(@PathVariable String code, @RequestBody User user){
        //得到缓存中的验证码
        String checkcodeRedis = (String) redisTemplate.opsForValue().get("checkcode_" + user.getMobile());
        if(checkcodeRedis.isEmpty()){
            return new Result(false, StatusCode.ERROR, "请先获取手机验证码");
        }
        if(!checkcodeRedis.equals(code)){
            return new Result(false, StatusCode.ERROR, "请输入正确的验证码");
        }
        userService.add(user);
        return new Result(true, StatusCode.OK, "注册成功");
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Result login(String mobile,String password){
        User user = userService.findByMobileAndPassword(mobile,password);
        if (user != null){
            String token = jwtUtil.createJWT(user.getId(),user.getNickname(),"user");
            Map resultMap = new HashMap();
            resultMap.put("token",token);
            resultMap.put("name",user.getNickname());
            resultMap.put("avatar",user.getAvatar());
            return new Result(true, StatusCode.OK,"登录成功",resultMap);
        }else{
            return  new Result(false,StatusCode.LOGINERROR,"手机号或密码错误");
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        Claims claims = (Claims) request.getAttribute("admin_claims");
        if (claims == null){
            return new Result(true,StatusCode.ACCESSERROR,"无权限访问");
        }
        userService.deleteById(id);
        return  new Result(true,StatusCode.OK,"删除成功");
    }
}
