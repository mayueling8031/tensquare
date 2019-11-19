package com.tensquare.recruit.dao;

import com.tensquare.recruit.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {

    /**
     * 查询最新职位 （按创建日期排序）
     * @reture
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    /**
     * 查询最新推荐职位（不为0）
     */
    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);
}
