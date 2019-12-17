package com.tensquare.friend.service;


import com.tensquare.friend.client.UserClient;
import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.dao.NoFriendDao;
import com.tensquare.friend.pojo.Friend;
import com.tensquare.friend.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendService {

    @Autowired
    private FriendDao friendDao;
    @Autowired
    private NoFriendDao noFriendDao;

    @Autowired
    private UserClient userClient;

    @Transactional
    public int addFriend(String userId, String friendId) {
        //判断如果用户已经添加了这个好友，则不进行任何操作，返回0
        if (friendDao.selectCount(userId, friendId) > 0) {
            return 0;
        }
        //向喜欢表中插入数据
        Friend friend = new Friend();
        friend.setUserid(userId);
        friend.setFriendid(friendId);
        friend.setIslike("0");
        friendDao.save(friend);
        userClient.incFansCount(userId,1);
        userClient.incFollowCount(friendId,1);
        //判断对方是否喜欢你吗，如果喜欢，将isLike设置为1
        if (friendDao.selectCount(friendId, userId) > 0) {
            friendDao.updateLike(userId, friendId, "1");
            friendDao.updateLike(friendId, userId, "1");
        }
        return 1;
    }

    /**
     * 向不喜欢列表中添加记录
     *
     * @param userId
     * @param friendId
     */
    public void addNoFriend(String userId, String friendId) {
        NoFriend noFriend = new NoFriend(userId, friendId);
        noFriendDao.save(noFriend);
    }

    /**
     * 删除好友
     * @param userId
     * @param friendId
     */
    public void deleteFriend(String userId, String friendId) {
        friendDao.deleteFriend(userId, friendId);
        friendDao.updateLike(friendId, userId, "0");
        addNoFriend(userId, friendId);
        userClient.incFansCount(userId,-1);
        userClient.incFollowCount(friendId,-1);
    }
}
