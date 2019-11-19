package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.entity.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    /**
     * 查询最新职位 （按创建日期排序）
     * @reture
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state){
        return recruitDao.findTop4ByStateOrderByCreatetimeDesc(state);
    }

    /**
     * 查询最新推荐职位（不为0）
     */
    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state){
        return recruitDao.findTop12ByStateNotOrderByCreatetimeDesc(state);
    }
}
