package com.tensquare.recruit.controller;

import com.tensquare.recruit.service.EnterpriseService;
import entity.Result;
import entity.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.BaseExceptionHandler;

@RestController
@CrossOrigin
@RequestMapping("/enterprise")
public class EnterpriseController extends BaseExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(EnterpriseController.class);

    @Autowired
    private EnterpriseService enterpriseService;

    @RequestMapping(value = "/search/hotlist",method = RequestMethod.GET)
    public Result hostList(){
        LOG.info("======查询开始======");
        return new Result(true, StatusCode.OK,"查询成功",enterpriseService.hotlist());
    }
}
