package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleSearchService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {
    @Autowired
    private ArticleSearchService searchService;

    /**
     * 添加文章
     * @param article
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article){
        searchService.add(article);
        return new Result(true, StatusCode.OK,"操作成功");
    }

    /**
     * 检索
     */
    @RequestMapping(value = "/search/{keyWords}/{page}/{size}",method = RequestMethod.GET)
    public Result findByTitleLike(@PathVariable String keyWords,
                                  @PathVariable int page, @PathVariable int size){
        Page<Article> articlePage = searchService.findByTitleLike(keyWords, page, size);
        return new Result(true,StatusCode.OK,"查询成功",
                new PageResult<Article>(articlePage.getTotalElements(),
                        articlePage.getContent()));
    }
}
