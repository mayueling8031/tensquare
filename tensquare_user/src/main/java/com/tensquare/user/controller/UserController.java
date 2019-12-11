package com.tensquare.user.controller;

import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.BaseExceptionHandler;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController extends BaseExceptionHandler {
    final static String TAG = "user===========>";
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody User loginUser){
        logger.info(TAG+loginUser);
        User user = userService.findByMobile(loginUser.getMobile(), loginUser.getPassword());
        if (user!=null){
            return new Result(true, StatusCode.OK,"登陆成功");
        }else {
            return new Result(false,StatusCode.LOGINERROR,"用户名或者密码错误");
        }
    }
}
