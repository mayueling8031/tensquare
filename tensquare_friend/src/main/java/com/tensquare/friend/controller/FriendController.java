package com.tensquare.friend.controller;

import com.tensquare.friend.service.FriendService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @Autowired
    private HttpServletRequest request;

    /**
     *
     * @param friendId
     * @param type 1喜欢 0不喜欢
     * @return
     */
    @RequestMapping(value = "/like/{friendId}/{type}",method = RequestMethod.PUT)
    public Result addFriend(@PathVariable String friendId,@PathVariable String type){
        Claims claims = (Claims)request.getAttribute("user_claims");
        if (claims==null){
            return  new Result(false, StatusCode.ACCESSERROR,"无效访问");
        }
        if (type.equals("1")){
            if (friendService.addFriend(claims.getId(),friendId)==0){
                return new Result(false,StatusCode.REPERROR,"已经添加好友");
            }
            if (friendService.addFriend(claims.getId(),friendId)==1){
                return new Result(true,StatusCode.OK,"添加好友成功");
            }
        }else {
            //不喜欢
            friendService.addNoFriend(claims.getId(),friendId);
        }
        return new Result(true,StatusCode.OK,"操作成功");
    }

    @RequestMapping(value = "/{friendId}",method = RequestMethod.DELETE)
    public Result remove(@PathVariable String friendId){
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims==null){
            return new Result(false,StatusCode.ACCESSERROR,"无权访问");
        }
        friendService.deleteFriend(claims.getId(),friendId);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
