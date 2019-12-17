package com.tensquare.user.service;


import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private HttpServletRequest request;

    /**
     * 密码加密
     *
     * @param user
     */
    public void add(User user) {
        //主键值
        user.setId(idWorker.nextId() + "");
        //加密后的密码
        String newPassword = encoder.encode(user.getPassword());
        user.setPassword(newPassword);
        userDao.save(user);
    }

    public void deleteById(String id) {
        userDao.deleteById(id);
    }

    /**
     * 根据手机号和密码查询用户
     *
     * @param mobile
     * @param password
     * @return
     */
    public User findByMobile(String mobile, String password) {
        User user = userDao.findByMobile(mobile);
        if (user != null && encoder.matches(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * 更新粉丝数
     * @param userId
     * @param x
     */
    @Transactional
    public void incFansCount(String userId,int x){
        userDao.incFansCount(userId,x);
    }

    /**
     * 更新关注数
     * @param userId
     * @param x
     */
    @Transactional
    public void incFollowCount(String userId,int x){
        userDao.incFollowCount(userId,x);
    }
}
