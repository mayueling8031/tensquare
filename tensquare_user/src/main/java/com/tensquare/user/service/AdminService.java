package com.tensquare.user.service;

import com.tensquare.user.dao.AdminDao;
import com.tensquare.user.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private BCryptPasswordEncoder encoder;

    /**
     * 查询管理员用户
     */
    public List<Admin> findAll(){
        List<Admin> adminList = adminDao.findAll();
        return adminList;
    }
    /**
     * 密码加密
     *
     * @param admin
     */
    public void add(Admin admin) {
        //主键值
        admin.setId(idWorker.nextId() + "");
        //加密后的密码
        String newPassword = encoder.encode(admin.getPassword());
        admin.setPassword(newPassword);
        admin.setState("1");
        adminDao.save(admin);
    }

    /**
     * 根据登陆名和密码查询
     * @param loginName
     * @param password
     * @return admin
     */
    public Admin findByLoginNameAndPassWord(String loginName, String password) {
        Admin admin = adminDao.findByLoginname(loginName);
        if (admin != null && encoder.matches(password,admin.getPassword())){
            return admin;
        }else {
            return null;
        }
    }
}
