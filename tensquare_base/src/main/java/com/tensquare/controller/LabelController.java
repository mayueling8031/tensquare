package com.tensquare.controller;

import com.tensquare.pojo.Label;
import com.tensquare.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.BaseExceptionHandler;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController extends BaseExceptionHandler {

    @Autowired
    private LabelService service;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",service.findAll());
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId){
        return new Result(true,StatusCode.OK,"查询成功",service.findById(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        service.save(label);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable("labelId") String labelId,@RequestBody Label label){
        label.setId(labelId);
        service.update(label);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("labelId") String labelId){
        service.deleteById(labelId);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        List<Label> list = service.findASearch(label);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }
}
