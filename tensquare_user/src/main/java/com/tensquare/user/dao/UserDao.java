package com.tensquare.user.dao;

import com.tensquare.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {


    /**
     * 根据手机号码查询
     * @param mobile
     * @return
     */
    public User findByMobile(String mobile);

    /**
     * 更新粉丝数
     * @param userId
     * @param x
     */
    @Modifying
    @Query("update User u set u.fanscount=u.fanscount+?2 where u.id=?1")
    public void incFansCount(String userId,int x);

    /**
     * 更新关注数
     * @param userId
     * @param x
     */
    @Modifying
    @Query("update User u set u.followcount=u.followcount+?2 where u.id=?1")
    public void incFollowCount(String userId,int x);
}
