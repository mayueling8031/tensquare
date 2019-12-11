package com.tensquare.user.dao;

import com.tensquare.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface UserDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {


    /**
     * 根据手机号码查询
     * @param mobile
     * @return
     */
    public User findByMobile(String mobile);

}
