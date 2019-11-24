package com.tensquare.article.dao;

import com.tensquare.article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ArticleDao extends JpaRepository<Article,String> , JpaSpecificationExecutor<Article> {
    /**
     * 文章审核
     */
    @Modifying
    @Query(value = "update tb_article set state='1' where id=?1",nativeQuery = true)
    public void examine(String id);

    /**
     * 文章点赞
     */
    @Modifying
    @Query(value = "update tb_article set thumbup=thumbup+1 where id=?1",nativeQuery = true)
    public int updateThumbup(String id);


}
