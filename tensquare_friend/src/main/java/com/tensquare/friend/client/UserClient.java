package com.tensquare.friend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("tensquare-user")
public interface UserClient {

    /**
     * 增加粉丝数
     * @param userId
     * @param x
     */
    @RequestMapping(value = "user/incfans/{userId}/{x}",method = RequestMethod.POST)
    public void incFansCount(@PathVariable String userId,@PathVariable int x);

    /**
     * 增加关注数
     * @param userId
     * @param x
     */
    @RequestMapping(value = "user/incfollow/{userId}/{x}",method = RequestMethod.POST)
    public void incFollowCount(@PathVariable String userId,@PathVariable int x);
}
