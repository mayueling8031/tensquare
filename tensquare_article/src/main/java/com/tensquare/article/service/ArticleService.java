package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArticleService  {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    public List<Article> findAll(){
        return articleDao.findAll();
    }

    @Cacheable(value = "getArticle",key = "#id")
    public Article findById(String id){
        return articleDao.findById(id).get();
    }

    public void save(Article article){
        article.setId(idWorker.nextId()+"");
        articleDao.save(article);
    }

    @CacheEvict(value = "getArticle",key = "#article.id")
    public void update(Article article){
        articleDao.save(article);
    }

    @CacheEvict(value = "getArticle",key = "#id")
    public void deleteById(String id){
        articleDao.deleteById(id);
    }

    /**
     * 文章审核
     */
    public void examine(String id){
        articleDao.examine(id);
    }

    /**
     * 文章点赞
     */
    public int updateThumbup(String id){
        return articleDao.updateThumbup(id);
    }


}
