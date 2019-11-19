package com.tensquare.qa.controller;

import com.tensquare.qa.entity.Problem;
import com.tensquare.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("problem")
public class ProblemController extends BaseExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ProblemController.class);

    @Autowired
    private ProblemService problemService;

    /**
     * 根据标签ID查询最新问题列表
     *
     * @param labelid 标签
     * @param page    页码
     * @param size    页大小
     * @return Problem
     */
    @RequestMapping(value = "/newlist/{labelid}/{page}/{size}", method = RequestMethod.GET)
    public Result newList(@PathVariable int labelid, @PathVariable int page,
                          @PathVariable int size) {
        LOG.info("=======>"+labelid+"=======>"+page+"=======>"+size);
        Page<Problem> list = problemService.newList(String.valueOf(labelid), page, size);
        PageResult<Problem> pageRequest = new PageResult<>(list.getTotalElements(), list.getContent());
        return new Result(true, StatusCode.OK, "查询成功", pageRequest);
    }

    /**
     * 根据最热问题列表
     *
     * @param labelid 标签
     * @param page    页码
     * @param size    页大小
     * @return Problem
     */
    @RequestMapping(value = "/hotlist/{labelid}/{page}/{size}", method = RequestMethod.GET)
    public Result hotList(@PathVariable int labelid, @PathVariable int page,
                          @PathVariable int size) {
        LOG.info("=======>"+labelid+"=======>"+page+"=======>"+size);
        Page<Problem> list = problemService.hotList(String.valueOf(labelid), page, size);
        PageResult<Problem> pageRequest = new PageResult<>(list.getTotalElements(), list.getContent());
        return new Result(true, StatusCode.OK, "查询成功", pageRequest);
    }

    /**
     * 根据查询等待问题列表
     *
     * @param labelid 标签
     * @param page    页码
     * @param size    页大小
     * @return Problem
     */
    @RequestMapping(value = "/waitlist/{labelid}/{page}/{size}", method = RequestMethod.GET)
    public Result waitList(@PathVariable int labelid, @PathVariable int page,
                           @PathVariable int size) {
        LOG.info("=======>"+labelid+"=======>"+page+"=======>"+size);
        Page<Problem> list = problemService.waitList(String.valueOf(labelid), page, size);
        PageResult<Problem> pageRequest = new PageResult<>(list.getTotalElements(), list.getContent());
        return new Result(true, StatusCode.OK, "查询成功", pageRequest);
    }
}
