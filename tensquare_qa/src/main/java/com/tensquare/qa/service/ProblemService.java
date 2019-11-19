package com.tensquare.qa.service;

import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.entity.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProblemService  {

    @Autowired
    private ProblemDao problemDao;
    /**
     * 根据标签ID查询最新问题列表
     * @param labelId 标签
     * @param page 页码
     * @param size 页大小
     * @return Problem
     */
    public Page<Problem> newList(String labelId, int page,int size){
        PageRequest request = PageRequest.of(page-1,size);
        return problemDao.newList(labelId,request);
    }
    /**
     * 根据最热问题列表
     * @param labelId 标签
     * @param page 页码
     * @param size 页大小
     * @return Problem
     */
    public Page<Problem> hotList(String labelId, int page,int size){
        PageRequest request = PageRequest.of(page-1,size);
        return problemDao.hotList(labelId,request);
    }
    /**
     * 根据查询等待问题列表
     * @param labelId 标签
     * @param page 页码
     * @param size 页大小
     * @return Problem
     */
    public Page<Problem> waitList(String labelId, int page,int size){
        PageRequest request = PageRequest.of(page-1,size);
        return problemDao.waitList(labelId,request);
    }
}
