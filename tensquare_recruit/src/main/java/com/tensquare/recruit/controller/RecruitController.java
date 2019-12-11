package com.tensquare.recruit.controller;

import com.tensquare.recruit.entity.Recruit;
import com.tensquare.recruit.service.RecruitService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.BaseExceptionHandler;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController extends BaseExceptionHandler {

    @Autowired
    private RecruitService recruitService;

    @RequestMapping(value="/search/recommend",method= RequestMethod.GET)
    public Result recommend(){
        List<Recruit> list = recruitService.findTop4ByStateOrderByCreatetimeDesc("2");
        return new Result(true, StatusCode.OK,"查询成功",list);
    }

    @RequestMapping(value="/search/newlist",method= RequestMethod.GET)
    public Result newList(){
        List<Recruit> list = recruitService.findTop12ByStateNotOrderByCreatetimeDesc("0");
        return new Result(true, StatusCode.OK,"查询成功",list);
    }
}
