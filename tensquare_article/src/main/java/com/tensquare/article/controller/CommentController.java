package com.tensquare.article.controller;

import com.tensquare.article.model.Comment;
import com.tensquare.article.service.CommentService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController extends BaseExceptionHandler{
    @Autowired
    private CommentService service;

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Comment comment){
        service.add(comment);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    /**
     * 根据文章Id查询评论
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/article/{articleId}",method = RequestMethod.POST)
    public Result findById(@PathVariable String articleId){
        List<Comment> list = service.findByArticleId(articleId);
        return new Result(true, StatusCode.OK,"添加成功",list);
    }

    /**
     * 删除评论
     * @param commentId
     * @return
     */
    @RequestMapping(value = "comment/{commentId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String commentId){
        service.delete(commentId);
        return new Result(true, StatusCode.OK,"删除成功");
    }
}
