package com.tensquare.article.controller;

import com.tensquare.article.model.Article;
import com.tensquare.article.service.ArticleService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.BaseExceptionHandler;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController extends BaseExceptionHandler {
    @Autowired
    private ArticleService service;


    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",service.findAll());
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id){
        return new Result(true,StatusCode.OK,"查询成功",service.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article){
        service.save(article);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable("id") String id,@RequestBody Article article){
        article.setId(id);
        service.update(article);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("id") String id){
        service.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 文章审核
     */
    @RequestMapping(value = "/examine/{id}",method = RequestMethod.PUT)
    public Result examine(@PathVariable String id){
        service.examine(id);
        return new Result(true, StatusCode.OK,"审核成功");
    }

    /**
     * 文章点赞
     */
    @RequestMapping(value = "/thumbup/{id}",method = RequestMethod.PUT)
    public Result updateThumbup(@PathVariable String id){
        service.updateThumbup(id);
        return new Result(true, StatusCode.OK,"点赞成功");
    }
}
