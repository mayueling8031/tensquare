package com.tensquare.user.controller;

import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.BaseExceptionHandler;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController extends BaseExceptionHandler {
    final static String TAG = "user===========>";
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User loginUser) {
        logger.info(TAG + loginUser);
        User user = userService.findByMobile(loginUser.getMobile(), loginUser.getPassword());
        if (user != null) {
            String token = jwtUtil.createJWT(user.getId(), user.getNickname(), "user");
            Map<String,String> map = new HashMap<>(16);
            map.put("token",token);
            //昵称
            map.put("name",user.getNickname());
            //头像
            map.put("avatar",user.getAvatar());
            return new Result(true, StatusCode.OK, "登陆成功",map);
        } else {
            return new Result(false, StatusCode.LOGINERROR, "用户名或者密码错误");
        }
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result add(@RequestBody User user){
        logger.info(TAG+user);
        userService.add(user);
        return new Result(true, StatusCode.OK, "注册成功");
    }
    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        //获取请求头信息
        Claims claims = (Claims) request.getAttribute("admin_claims");
        if (claims == null) {
            return new Result(true, StatusCode.ACCESSERROR, "无权访问");
        }
        userService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
