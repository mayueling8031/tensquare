package com.tensquare.article.service;


import com.tensquare.article.dao.CommentDao;
import com.tensquare.article.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 添加评论
     */
    public void add(Comment comment){
        comment.set_id(idWorker.nextId()+"");
        commentDao.save(comment);
    }

    /**
     * 根据文章Id查询评论
     */
    public List<Comment> findByArticleId(String id){
        return commentDao.findByArticleid(id);
    }
    /**
     * 根据Id删除评论
     */
    public void delete(String id){
        commentDao.deleteById(id);
    }
}
