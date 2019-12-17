package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FriendDao extends JpaRepository<Friend,String> {

    /**
     * 根据用户Id与被关注用户Id查询记录个数
     * @param userId
     * @param friendId
     * @return
     */
    @Query("select count(f) from Friend f where f.userid=?1 and f.friendid=?2")
    public int selectCount(String userId,String friendId);

    /**
     * 跟新互相喜欢
     * @param userId
     * @param friendId
     * @param isLike
     */
    @Modifying
    @Query("update Friend f set f.islike=?3 where f.userid=?1 and f.friendid=?2")
    public void updateLike(String userId,String friendId,String isLike);

    /**
     * 删除喜欢
     * @param userId
     * @param FriendId
     */
    @Modifying
    @Query("delete from Friend f where f.userid=?1 and f.friendid=?2")
    public void deleteFriend(String userId,String FriendId);

}
