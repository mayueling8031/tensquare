package com.tensquare.user.controller;

import com.tensquare.user.pojo.Admin;
import com.tensquare.user.service.AdminService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.BaseExceptionHandler;
import util.JwtUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController extends BaseExceptionHandler {
    final static String TAG = "admin==========>";
    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@RequestBody Admin admin){
        logger.info(TAG+admin);
        adminService.add(admin);
        return new  Result(true,StatusCode.OK,"注册成功");
    }
    /**
     * 查询
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<Admin> adminList = adminService.findAll();
        return new Result(true,StatusCode.OK,"查询成功",adminList);
    }
    /**
     * 登陆
     * @param loginAdmin
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody Admin loginAdmin){
        logger.info(TAG+loginAdmin);
        Admin admin = adminService.findByLoginNameAndPassWord(loginAdmin.getLoginname(), loginAdmin.getPassword());
        if (admin!=null){
            String token = jwtUtil.createJWT(admin.getId(), admin.getLoginname(), "admin");
            Map<String,String> map = new HashMap<String,String>(16);
            map.put("token",token);
            //加入登陆名
            map.put("name",admin.getLoginname());
            return new Result(true, StatusCode.OK,"登陆成功",map);
        }else {
            return new Result(false,StatusCode.LOGINERROR,"用户名或者密码错误");
        }
    }
}
