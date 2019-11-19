package com.tensquare.qa.dao;

import com.tensquare.qa.entity.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


public interface ProblemDao extends JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {
    /**
     * 根据标签ID查询最新问题列表
     */
    @Query(value ="SELECT * FROM tb_problem ,tb_pl WHERE id = problemid AND labelid = ? ORDER BY replytime DESC",nativeQuery = true)
    public Page<Problem> newList(String labelId, Pageable pageable);
    /**
     * 根据最热问题列表
     */
    @Query(value ="SELECT * FROM tb_problem ,tb_pl WHERE id = problemid AND labelid = ? ORDER BY reply DESC",nativeQuery = true)
    public Page<Problem> hotList(String labelId, Pageable pageable);
    /**
     * 根据查询等待问题列表
     */
    @Query(value ="SELECT * FROM tb_problem ,tb_pl WHERE id = problemid AND labelid = ? and reply=0 ORDER BY createtime DESC",nativeQuery = true)
    public Page<Problem> waitList(String labelId, Pageable pageable);
}
