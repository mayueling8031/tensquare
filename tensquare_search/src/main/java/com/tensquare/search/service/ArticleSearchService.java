package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class ArticleSearchService   {

    @Autowired
    private ArticleSearchDao searchDao;

    /**
     * 添加文章
     */
    public void add(Article article){
        searchDao.save(article);
    }


    /**
     * 检索
     */
    public Page<Article> findByTitleLike(String keyWords,int page,int size){
        PageRequest pageRequest = PageRequest.of(page-1,size);
        return searchDao.findByTitleOrContentLike(keyWords,keyWords,pageRequest);
    }
}
